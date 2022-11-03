package com.example.socket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socket.Activity.TalkActivity;
import com.nononsenseapps.filepicker.FilePickerActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int FILE_CODE = 0;
    private TextView tvMsg;
    private EditText txtIP, txtPort, txtEt;
    private Button btnSend, btnIntent;
    private Handler handler;
    private SocketManager socketManager;

    ArrayList<String> fileNames = new ArrayList<>();
    ArrayList<String> paths = new ArrayList<>();

    String ipAddress = "";
    int port = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMsg = (TextView) findViewById(R.id.tvMsg);
        txtIP = (EditText) findViewById(R.id.txtIP);
        txtIP.setText(GetIpAddress());
        txtPort = (EditText) findViewById(R.id.txtPort);
        txtEt = (EditText) findViewById(R.id.et);
        btnSend = (Button) findViewById(R.id.btnSend);
        btnIntent = findViewById(R.id.btnInent);
        btnIntent.setOnClickListener(this);

        // Assume thisActivity is the current activity
        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_CALENDAR);
        System.out.println(permissionCheck);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FilePickerActivity.class);
                i.putExtra(FilePickerActivity.EXTRA_ALLOW_MULTIPLE, true);
                i.putExtra(FilePickerActivity.EXTRA_ALLOW_CREATE_DIR, false);
                i.putExtra(FilePickerActivity.EXTRA_MODE, FilePickerActivity.MODE_FILE);
                i.putExtra(FilePickerActivity.EXTRA_START_PATH, Environment.getExternalStorageDirectory().getPath());

                startActivityForResult(i, FILE_CODE);
            }
        });
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
                        txtEt.append("\n[" + format.format(new Date()) + "]" + msg.obj.toString());
                        break;
                    case 1:
                        tvMsg.setText("本机IP：" + GetIpAddress() + " 监听端口:" + msg.obj.toString());
                        break;
                    case 2:
                        //list.clear();
                        //getallfiles();
                        //
                        /*if (msg.obj.toString().matches(fileNames.get(0))) {
                            ipAddress = txtIP.getText().toString();
                            port = Integer.parseInt(txtPort.getText().toString());
                            fileNames.remove(0);
                            paths.remove(0);
                            if (!fileNames.isEmpty()) {
                                Thread sendThread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        socketManager.SendFile(fileNames.get(0), paths.get(0), ipAddress, port);
                                    }
                                });
                                sendThread.start();
                            }
                        }*/
                        break;
                }
            }
        };
        socketManager = new SocketManager(handler);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_CODE && resultCode == Activity.RESULT_OK) {
            if (data.getBooleanExtra(FilePickerActivity.EXTRA_ALLOW_MULTIPLE, true)) {
                // For JellyBean and above
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    fileNames.clear();
                    paths.clear();
                    ipAddress = txtIP.getText().toString();
                    port = Integer.parseInt(txtPort.getText().toString());
                    Log.e("swy", "onActivityResult:   1");
                    ClipData clip = data.getClipData();
                    if (clip != null) {
                        for (int i = 0; i < clip.getItemCount(); i++) {
                            Uri uri = clip.getItemAt(i).getUri();
                            paths.add(uri.getPath());
                            fileNames.add(uri.getLastPathSegment());
                        }
                        Message.obtain(handler, 0, "正在发送至" + ipAddress + ":" + port).sendToTarget();

                        Thread sendThread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                socketManager.SendFile(fileNames.get(0), paths.get(0), ipAddress, port);
                            }
                        });
                        sendThread.start();
                    }
                } else {
                    ipAddress = txtIP.getText().toString();
                    port = Integer.parseInt(txtPort.getText().toString());
                    Log.e("swy", "onActivityResult:   2");
                    paths = data.getStringArrayListExtra
                            (FilePickerActivity.EXTRA_PATHS);
                    fileNames = new ArrayList<>();
                    if (paths != null) {
                        for (String path : paths) {
                            Uri uri = Uri.parse(path);
                            paths.add(uri.getPath());
                            fileNames.add(uri.getLastPathSegment());
                            //socketManager.SendFile(fileNames, paths, ipAddress, port);
                        }
                        Message.obtain(handler, 0, "正在发送至" + ipAddress + ":" + port).sendToTarget();
                        Thread sendThread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                socketManager.SendFile(fileNames.get(0), paths.get(0), ipAddress, port);
                            }
                        });
                        sendThread.start();
                    }
                }

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    public String GetIpAddress() {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int i = wifiInfo.getIpAddress();
        return (i & 0xFF) + "." +
                ((i >> 8) & 0xFF) + "." +
                ((i >> 16) & 0xFF) + "." +
                ((i >> 24) & 0xFF);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInent:
                Intent intent = new Intent(MainActivity.this, TalkActivity.class);
                startActivity(intent);
                break;
        }
    }
}
