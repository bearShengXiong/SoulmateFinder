package com.example.shengxiong.soulmatefinder.model;

import java.util.Vector;

/**
 * Created by Shengxiong on 2016/9/29.
 */

public class TruthTable {
    private int mOutput1;
    private int mOutput2;
    private int mOutput3;
    private int mOutput4;

    public TruthTable(int value1, int value2,int value3,int value4){
        mOutput1 = value1;
        mOutput2 = value2;
        mOutput3 = value3;
        mOutput4 = value4;

    }

    public int getOutput1() {
        return mOutput1;
    }

    public void setOutput1(int output1) {
        mOutput1 = output1;
    }

    public int getOutput2() {
        return mOutput2;
    }

    public void setOutput2(int output2) {
        mOutput2 = output2;
    }

    public int getOutput3() {
        return mOutput3;
    }

    public void setOutput3(int output3) {
        mOutput3 = output3;
    }

    public int getOutput4() {
        return mOutput4;
    }

    public void setOutput4(int output4) {
        mOutput4 = output4;
    }


}
