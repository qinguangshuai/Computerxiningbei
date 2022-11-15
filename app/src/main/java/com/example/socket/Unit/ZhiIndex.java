package com.example.socket.Unit;

import java.util.List;

public class ZhiIndex {
    //获取最小值下标
    public static int getMinIndex(List<Double> mList) {
        double min = mList.get(0);
        int index = 0;
        for (int i = 0; i < mList.size(); i++) {
            if (min > mList.get(i)) {
                min = mList.get(i);
                index = i;
            }
        }
        return index;
    }

    //获取最小值
    public static int getMin(List<Integer> mList) {
        int min = mList.get(0);
        for (int i = 0; i < mList.size(); i++) {
            if (min > mList.get(i)) {
                min = mList.get(i);
            }
        }
        return min;
    }

    //获取最大值下标
    public static int getMaxIndex(List<Double> mList) {
        double max = mList.get(0);
        int index = 0;
        for (int i = 0; i < mList.size(); i++) {
            if (max < mList.get(i)) {
                max = mList.get(i);
                index = i;
            }
        }
        return index;
    }

    //获取最大值
    public static int getMax(List<Integer> mList) {
        int max = mList.get(0);
        for (int i = 0; i < mList.size(); i++) {
            if (max > mList.get(i)) {
                max = mList.get(i);
            }
        }
        return max;
    }
}
