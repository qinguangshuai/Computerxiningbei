package com.example.socket.Bean;

import java.io.Serializable;

public class TestPocket implements Serializable {

    //音频数据
    short data[];

    public short[] getData() {
        return data;
    }

    public void setData(short[] data) {
        this.data = data;
    }


    public TestPocket(short[] data) {
        this.data = data;
    }

    public TestPocket(){

    }

    /**
     * 音频解码后的pcm文件路径
     */
    public String pcmPath;

    /**
     * 音频开始播放的时间
     */
    public float offsetSeconds;
}
