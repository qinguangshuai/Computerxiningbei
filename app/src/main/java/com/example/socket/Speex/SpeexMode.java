package com.example.socket.Speex;

public enum SpeexMode {
    // 窄带音频，对应采样率为8000,framesize为160
    SPEEX_NB_MODE(0),
    // 宽带音频， 对应采样率为16000，framesize 320
    SPEEX_WB_MODE(1),
    // 超宽带音频，对应采样率为32000 ，framesize 640
    SPEEX_UWB_MODE(2);

    private int mode;
    private SpeexMode(int mode) {
        this.mode = mode;
    }

    public int mode() {
        return this.mode;
    }
}
