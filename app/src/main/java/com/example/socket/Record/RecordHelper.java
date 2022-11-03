package com.example.socket.Record;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.EditText;


import com.alibaba.fastjson.JSONObject;
import com.example.socket.Bean.Pocket;
import com.example.socket.Speex.Speex;
import com.example.socket.Speex.SpeexUtil;
import com.example.socket.Tcp.TcpHeplerClient;
import com.example.socket.Unit.Content;
import com.example.socket.Unit.HelperPacket;
import com.example.socket.Unit.HexUtil;
import com.example.socket.udp.UdpHelperClient;
import com.example.socket.udp.UdpHelperServer;
import com.nononsenseapps.filepicker.Utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.media.tv.TvContract.Programs.Genres.encode;
import static com.example.socket.Activity.TalkActivity.Ip_Adress;
import static com.example.socket.Activity.TalkActivity.group;
import static com.example.socket.Activity.TalkActivity.imei;
import static com.example.socket.Activity.TalkActivity.peopleId;
import static com.example.socket.Activity.TalkActivity.port;
import static com.example.socket.Activity.TalkActivity.benJi;
import static com.example.socket.Activity.TalkActivity.udpHelperServer;


//import fftlib.FftFactory;

/**
 * 原始音频收集处理
 */
public class RecordHelper {
    private static final String TAG = RecordHelper.class.getSimpleName();
    private volatile static RecordHelper instance;
    private volatile RecordState state = RecordState.IDLE;
    private static final int RECORD_AUDIO_BUFFER_TIMES = 1;

    private RecordStateListener recordStateListener;
    private RecordDataListener recordDataListener;
    private RecordSoundSizeListener recordSoundSizeListener;
    private RecordResultListener recordResultListener;
    private RecordFftDataListener recordFftDataListener;
    private RecordConfig currentConfig;
    private AudioRecordThread audioRecordThread;
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    private File resultFile = null;
    private File tmpFile = null;
    private List<File> files = new ArrayList<>();
    //    private Mp3EncodeThread mp3EncodeThread;
    private SpeexUtil speex;
    private int frameSize, recBufSize, playBufSize;

    private RecordHelper() {
    }

    static RecordHelper getInstance() {
        if (instance == null) {
            synchronized (RecordHelper.class) {
                if (instance == null) {
                    instance = new RecordHelper();
                }
            }
        }
        return instance;
    }

    RecordState getState() {
        return state;
    }

    void setRecordStateListener(RecordStateListener recordStateListener) {
        this.recordStateListener = recordStateListener;
    }

    void setRecordDataListener(RecordDataListener recordDataListener) {
        this.recordDataListener = recordDataListener;
    }

    void setRecordSoundSizeListener(RecordSoundSizeListener recordSoundSizeListener) {
        this.recordSoundSizeListener = recordSoundSizeListener;
    }

    void setRecordResultListener(RecordResultListener recordResultListener) {
        this.recordResultListener = recordResultListener;
    }

    public void setRecordFftDataListener(RecordFftDataListener recordFftDataListener) {
        this.recordFftDataListener = recordFftDataListener;
    }

    public void start(String filePath, RecordConfig config) {
        this.currentConfig = config;
        if (state != RecordState.IDLE && state != RecordState.STOP) {
            Logger.e(TAG, "状态异常当前状态： %s", state.name());
            return;
        }
        resultFile = new File(filePath);
        String tempFilePath = getTempFilePath();

        Logger.d(TAG, "----------------开始录制 %s------------------------", currentConfig.getFormat().name());
        Logger.d(TAG, "参数： %s", currentConfig.toString());
        Logger.i(TAG, "pcm缓存 tmpFile: %s", tempFilePath);
        Logger.i(TAG, "录音文件 resultFile: %s", filePath);


        tmpFile = new File(tempFilePath);
        audioRecordThread = new AudioRecordThread();
        audioRecordThread.start();

        if (speex == null) {
            //speex编解码
            speex = new SpeexUtil();
            //speex.init();
            int frameSize = speex.getFrameSize();
        }
    }

    public void stop() {
        notifyState();
        if (state == RecordState.IDLE) {
            Logger.e(TAG, "状态异常当前状态： %s", state.name());
            return;
        }

        if (state == RecordState.PAUSE) {
            audioRecordThread.makeFile();
            state = RecordState.IDLE;
            notifyState();
        } else {
            state = RecordState.STOP;
            notifyState();
        }
    }

    void pause() {
        if (state != RecordState.RECORDING) {
            Logger.e(TAG, "状态异常当前状态： %s", state.name());
            return;
        }
        state = RecordState.PAUSE;
        notifyState();
    }

    void resume() {
        if (state != RecordState.PAUSE) {
            Logger.e(TAG, "状态异常当前状态： %s", state.name());
            return;
        }
        String tempFilePath = getTempFilePath();
        Logger.i(TAG, "tmpPCM File: %s", tempFilePath);
        tmpFile = new File(tempFilePath);
        audioRecordThread = new AudioRecordThread();
        audioRecordThread.start();
    }

    private void notifyState() {
        if (recordStateListener == null) {
            return;
        }
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                recordStateListener.onStateChange(state);
            }
        });

        if (state == RecordState.STOP || state == RecordState.PAUSE) {
            if (recordSoundSizeListener != null) {
                recordSoundSizeListener.onSoundSize(0);
            }
        }
    }

    private void notifyFinish() {
        cao = 0;
        Logger.d(TAG, "录音结束 file: %s", resultFile.getAbsolutePath());

        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                if (recordStateListener != null) {
                    recordStateListener.onStateChange(RecordState.FINISH);
                }
                if (recordResultListener != null) {
                    recordResultListener.onResult(resultFile);
                }
            }
        });
    }

    private void notifyError(final String error) {
        if (recordStateListener == null) {
            return;
        }
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                recordStateListener.onError(error);
            }
        });
    }

    private FftFactory fftFactory = new FftFactory(FftFactory.Level.Original);


    int cao = 1;

    void resetNum() {
        cao = 1;
    }


    //UdpHelperServer udpHelperServer = new UdpHelperServer();

    byte[] processedData;

    //
    private void notifyData(final short[] data) {
        int totleByte = 0;
        processedData = new byte[320];
        totleByte = speex.encode(data, 0, processedData, 320);// 编码后的总字节长度

        if (totleByte != 0) {
            Log.e("SPEEX", "编码成功 字节数组长度 = " + totleByte
                    + " ， short[] 长度 = " + data.length);
        } else {
            Log.e("swy", "speex编码失败！");
        }

        byte[] b = new byte[totleByte];
        System.arraycopy(processedData, 0, b, 0, totleByte);
        Pocket p = new Pocket();
        //单片机
        //p.setNum(cao);
        //多方
        p.setType("audio");
        p.setData(b);
        p.setNum(cao);
        p.setGroup(group);
        p.setPeopleId(peopleId);
        p.setTime(System.currentTimeMillis());
        p.setIpAdress(benJi);
        p.setImei(imei);
        p.setEnd(false);
        Log.e("swy", "cur" + cao);
        //与单片机通讯
        //byte[] send_num = HexUtil.splicingArrays("{[num:".getBytes(), HexUtil.intToBytes(cao), "],[data:".getBytes(), b, "],[end:false]".getBytes(), "}".getBytes());

        //4g
        //sendMessage("2",(JSONObject.toJSONString(p)));

//      helper.getMessage();


        //边采集边发送 udp
        //udpHelperClient.sendMessage(send_num,Ip_Adress,port);
        udpHelperServer.sendStrMessage(JSONObject.toJSONString(p), Content.Ip_Adress, Content.port);

        //边采集边发送 tcp
        //tcpHeplerClient.sendSpeex(savePath.replace("/mnt/sdcard/",""),savePath,Ip_Adress,port);
        //tcpHeplerClient.sendMessage(b, Ip_Adress, port);
        //tcpHeplerClient.sendMessage(JSONObject.toJSONString(p),Ip_Adress,port);
        //tcpHeplerClient.sendMessage(JSONObject.toJSONBytes(p),Ip_Adress,port);
        //tcpHeplerClient.sendMessage(send_num, Ip_Adress, port);


        cao++;
        if (recordDataListener == null && recordSoundSizeListener == null && recordFftDataListener == null) {
            return;
        }
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                if (recordDataListener != null) {
                    recordDataListener.onData(processedData);
                }

                if (recordFftDataListener != null || recordSoundSizeListener != null) {
                    byte[] fftData = fftFactory.makeFftData(processedData);
                    if (fftData != null) {
                        if (recordSoundSizeListener != null) {
                            recordSoundSizeListener.onSoundSize(getDb(fftData));
                            Log.e(TAG, "run: ");
                        }
                        if (recordFftDataListener != null) {
                            recordFftDataListener.onFftData(fftData);
                        }
                    }
                }
            }
        });
    }


    private String getTempFilePath() {
        String fileDir = String.format(Locale.getDefault(), "%s/Record/", Environment.getExternalStorageDirectory().getAbsolutePath());
        if (!FileUtils.createOrExistsDir(fileDir)) {
            Logger.e(TAG, "文件夹创建失败：%s", fileDir);
        }
        String fileName = String.format(Locale.getDefault(), "record_tmp_%s", FileUtils.getNowString(new SimpleDateFormat("yyyyMMdd_HH_mm_ss", Locale.SIMPLIFIED_CHINESE)));
        return String.format(Locale.getDefault(), "%s%s.pcm", fileDir, fileName);
    }

    private int getDb(byte[] data) {
        double sum = 0;
        double ave;
        int length = data.length > 128 ? 128 : data.length;
        int offsetStart = 8;
        for (int i = offsetStart; i < length; i++) {
            sum += data[i];
        }
        ave = (sum / (length - offsetStart)) * 65536 / 128f;
        int i = (int) (Math.log10(ave) * 20);
        return i < 0 ? 27 : i;
    }

    public int getNum() {
        return cao;
    }

//    private void initMp3EncoderThread(int bufferSize) {
//        try {
//            mp3EncodeThread = new Mp3EncodeThread(resultFile, bufferSize);
//            mp3EncodeThread.start();
//        } catch (Exception e) {
//            Logger.e(e, TAG, e.getMessage());
//        }
//    }

    private class AudioRecordThread extends Thread {
        private AudioRecord audioRecord;
        private int bufferSize;

        AudioRecordThread() {
            /*bufferSize = AudioRecord.getMinBufferSize(currentConfig.getSampleRate(),
                    currentConfig.getChannelConfig(), currentConfig.getEncodingConfig()) * RECORD_AUDIO_BUFFER_TIMES;

            Log.e(TAG, "AudioRecordThread  bufferSize: "+ bufferSize);
            Logger.d(TAG, "record buffer size = %s", bufferSize);
            audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, currentConfig.getSampleRate(),
                    currentConfig.getChannelConfig(), currentConfig.getEncodingConfig(), bufferSize);*/


            bufferSize = AudioRecord.getMinBufferSize(16000,
                    16, 2);

            Log.e(TAG, "AudioRecordThread  bufferSize: " + bufferSize);
            Logger.d(TAG, "record buffer size = %s", bufferSize);
            audioRecord = new AudioRecord(MediaRecorder.AudioSource.VOICE_COMMUNICATION, 16000,
                    16, 2, bufferSize);

//            if (currentConfig.getFormat() == RecordConfig.RecordFormat.MP3) {
//                if (mp3EncodeThread == null) {
//                    initMp3EncoderThread(bufferSize);
//                } else {
//                    Logger.e(TAG, "mp3EncodeThread != null, 请检查代码");
//                }
//            }
        }

        @Override
        public void run() {
            super.run();
            startPcmRecorder();

        }

        private void sendEnd() {
            Pocket p = new Pocket();
            byte b[] = new byte[10];
            p.setData(b);
            p.setEnd(true);
            //多方
            p.setType("audio");
            p.setNum(cao -= 1);
            p.setTime(System.currentTimeMillis());
            p.setIpAdress(benJi);
            p.setGroup(group);
            p.setPeopleId(peopleId);
            p.setImei(imei);
            //p.setNum(cao -= 1);
            //与单片机通讯
            //byte[] send_num= HexUtil.splicingArrays("{[num:".getBytes(),HexUtil.intToBytes(cao),"],[data:".getBytes(),b,"],[end:true]".getBytes(),"}".getBytes());


            //边采集边发送 udp
            //udpHelperClient.sendMessage(send_num,Ip_Adress,port);
            udpHelperServer.sendStrMessage(JSONObject.toJSONString(p), Content.Ip_Adress, Content.port);

            //边采集边发送 tcp
            //tcpHeplerClient.sendMessage(b,Ip_Adress,port);
            //tcpHeplerClient.sendMessage(JSONObject.toJSONString(p),Ip_Adress,port);
            //tcpHeplerClient.sendMessage(JSONObject.toJSONBytes(p),Ip_Adress,port);
            //tcpHeplerClient.sendMessage(send_num,Ip_Adress,port);

            resetNum();
            Log.e("lei", "end");
        }

        private void startPcmRecorder() {
            state = RecordState.RECORDING;
            Log.e("wocao", "start pcm");
            Logger.d(TAG, "开始录制 Pcm");
            FileOutputStream fos = null;
            try {
                //写入录音文件RecordManager
                //fos = new FileOutputStream(tmpFile);
                audioRecord.startRecording();
                short[] byteBuffer = new short[320];
                while (state == RecordState.RECORDING) {
                    int end = audioRecord.read(byteBuffer, 0, byteBuffer.length);
                    notifyData(byteBuffer);
                    //fos.write(byteBuffer, 0, end);
                    //fos.flush();
                }
                audioRecord.stop();
                sendEnd();
                files.add(tmpFile);
                if (state == RecordState.STOP) {
                    //makeFile();
                } else {
                    Logger.i(TAG, "暂停！");
                }
            } catch (Exception e) {
                Logger.e(e, TAG, e.getMessage());
                notifyError("录音失败");
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (state != RecordState.PAUSE) {
                state = RecordState.IDLE;
                notifyState();
                Logger.d(TAG, "录音结束");
            }
        }


        private void makeFile() {
            mergePcmFile();
            notifyFinish();
            Logger.i(TAG, "录音完成！ path: %s ； 大小：%s", resultFile.getAbsoluteFile(), resultFile.length());
        }

        /**
         * 添加Wav头文件
         */
//    private void makeWav() {
//        if (!FileUtils.isFile(resultFile) || resultFile.length() == 0) {
//            return;
//        }
//        byte[] header = WavUtils.generateWavFileHeader((int) resultFile.length(), currentConfig.getSampleRate(), currentConfig.getChannelCount(), currentConfig.getEncoding());
//        WavUtils.writeHeader(resultFile, header);
//    }

        /**
         * 合并文件
         */
        private void mergePcmFile() {
            boolean mergeSuccess = mergePcmFiles(resultFile, files);
            if (!mergeSuccess) {
                notifyError("合并失败");
            }
        }

        /**
         * 合并Pcm文件
         *
         * @param recordFile 输出文件
         * @param files      多个文件源
         * @return 是否成功
         */
        private boolean mergePcmFiles(File recordFile, List<File> files) {
            if (recordFile == null || files == null || files.size() <= 0) {
                return false;
            }

            FileOutputStream fos = null;
            BufferedOutputStream outputStream = null;
            byte[] buffer = new byte[1024];
            try {
                fos = new FileOutputStream(recordFile);
                outputStream = new BufferedOutputStream(fos);

                for (int i = 0; i < files.size(); i++) {
                    BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(files.get(i)));
                    int readCount;
                    while ((readCount = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, readCount);
                    }
                    inputStream.close();
                }
            } catch (Exception e) {
                //Logger.e(e, TAG, e.getMessage());
                return false;
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < files.size(); i++) {
                files.get(i).delete();
            }
            files.clear();
            return true;
        }

        /**
         * 根据当前的时间生成相应的文件名
         * 实例 record_20160101_13_15_12
         */
        private String getTempFilePath() {
            String fileDir = String.format(Locale.getDefault(), "%s/Record/", Environment.getExternalStorageDirectory().getAbsolutePath());
            if (!FileUtils.createOrExistsDir(fileDir)) {
                Logger.e(TAG, "文件夹创建失败：%s", fileDir);
            }
            String fileName = String.format(Locale.getDefault(), "record_tmp_%s", FileUtils.getNowString(new SimpleDateFormat("yyyyMMdd_HH_mm_ss", Locale.SIMPLIFIED_CHINESE)));
            return String.format(Locale.getDefault(), "%s%s.pcm", fileDir, fileName);
        }

        /**
         * 表示当前状态
         */

    }


}
