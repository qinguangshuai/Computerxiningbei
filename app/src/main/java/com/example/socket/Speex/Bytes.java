package com.example.socket.Speex;

public class Bytes {
    public Bytes() {
    }

    public static byte[] shortToByte(short var0) {
        int var1 = var0;
        byte[] var2 = new byte[2];

        for(int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = (new Integer(var1 & 255)).byteValue();
            var1 >>= 8;
        }

        return var2;
    }

    public static short byteToShort(byte[] var0) {
        boolean var1 = false;
        short var2 = (short)(var0[0] & 255);
        short var3 = (short)(var0[1] & 255);
        var3 = (short)(var3 << 8);
        short var4 = (short)(var2 | var3);
        return var4;
    }

    public static byte[] toByteArray(short[] var0) {
        int var1 = var0.length * 2;
        byte[] var2 = new byte[var1];

        for(int var3 = 0; var3 < var1; var3 += 2) {
            var2[var3] = (byte)(var0[var3 / 2] & 255);
            var2[var3 + 1] = (byte)(var0[var3 / 2] >> 8 & 255);
        }

        return var2;
    }

    protected static short[] toShortArray(byte[] var0) {
        int var1 = var0.length / 2;
        short[] var2 = new short[var1];

        for(int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = (short)(var0[var3 * 2 + 1] << 8 & '\uffff' | var0[var3 * 2] & 255);
        }

        return var2;
    }

    public static byte[] shortArray2ByteArray(short[] var0) {
        byte[] var1 = new byte[var0.length * 2];
        int var2 = 0;

        for(int var3 = 0; var3 < var0.length; ++var3) {
            short var4 = var0[var3];
            byte[] var5 = shortToByte(var4);
            var1[var2] = var5[0];
            var1[var2 + 1] = var5[1];
            var2 += 2;
        }

        return var1;
    }

    public static byte[] concat(byte[]... var0) {
        int var1 = 0;
        byte[][] var2 = var0;
        int var3 = var0.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte[] var5 = var2[var4];
            var1 += var5.length;
        }

        byte[] var8 = new byte[var1];
        var3 = 0;
        byte[][] var9 = var0;
        int var10 = var0.length;

        for(int var6 = 0; var6 < var10; ++var6) {
            byte[] var7 = var9[var6];
            System.arraycopy(var7, 0, var8, var3, var7.length);
            var3 += var7.length;
        }

        return var8;
    }
}
