package com.example.socket.Speex;

import java.io.Closeable;

public class SpeexUtil implements Closeable {
    // 压缩质量。默认为8
    private static final int DEFAULT_COMPRESSION = 8;

    private SpeexMode speexMode;

    static {
        try {
            // 加载实现so包。
            System.loadLibrary("speex");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SpeexUtil(){
        // 默认宽带，采样率16000，压缩质量8.
        this(DEFAULT_COMPRESSION, SpeexMode.SPEEX_WB_MODE);
    }

    public SpeexUtil(int compression, SpeexMode speexMode) {
        int res = open(compression, speexMode.mode());
        this.speexMode = speexMode;
        if (res != 0) {
            throw new RuntimeException("初始化失败！");
        }
    }

    /**
     * 将音频文件压缩成video,这里应该有个速查表，用于计算质量、采样率与帧、分子大小的。
     * 这里我们按照宽带，8来计算。其值为640:70
     * @param video 带压缩音频
     * @return 压缩后音频
     */
    public byte[] cpm2spx(byte[] video) {
        int length = video.length;
        int size = ((length - 1)/640+1)*70;
        byte[] encoded = new byte[size];
        encode(Bytes.toShortArray(video), 0, encoded, video.length);
        return encoded;
    }

    /**
     * 这里按照质量8，宽带处理。
     * @param encoded
     * @return
     */
    public byte[] spx2pcm(byte[] encoded){
        int length = encoded.length;
        // 没帧大小320
        int size = ((length - 1)/70 + 1)*320;
        short[] source = new short[size];
        int res = decode(encoded, source, length);
        System.out.println("解压结果：" + res);
        return Bytes.toByteArray(source);
    }

    /**
     * 初始化speex
     * @param compression 压缩质量
     * @return 初始化结果
     */
    public native int open(int compression, int mode);

    /**
     * 压缩方法,最好根据自己设置来整帧传入
     * @param source 待压缩文件
     * @param offset 偏移量，从什么位置开始压缩
     * @param encoded 压缩后数据
     * @param size 原数据大小
     * @return 返回压缩后的长度
     */
    public native int encode(short[] source, int offset, byte[] encoded, int size);

    /**
     * 音频文件解压
     * @param encoded 压缩数据
     * @param source 解压后的数据
     * @param size 压缩数据长度
     * @return 是否成功，0，成功，-1结束，-2失败
     */
    public native int decode(byte[] encoded, short[] source, int size);

    /**
     * 获取帧长度
     * @return 帧长度
     */
    public native int getFrameSize();
    /**
     * 关闭方法，实际就是释放资源
     */
    @Override
    public native void close();
}
