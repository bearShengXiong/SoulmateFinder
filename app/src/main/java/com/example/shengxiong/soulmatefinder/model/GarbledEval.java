package com.example.shengxiong.soulmatefinder.model;

/**
 * Created by Shengxiong on 2016/10/14.
 */

public class GarbledEval {
    private GarbledTruthTable mGarbledTruthTable;
    private int mAnswer1;
    private int mAnswer2;
    private int mOutput1;
    public GarbledEval(GarbledTruthTable garbledTruthTable, int int1, int int2) {
        mGarbledTruthTable = garbledTruthTable;
        mAnswer1 = int1;
        mAnswer2 = int2;
    }

    public int eval(){
        if(mAnswer1 == mGarbledTruthTable.getGarbledTruthTable()[0][0]&&
            mAnswer2 == mGarbledTruthTable.getGarbledTruthTable()[0][1]){
                mOutput1 = mGarbledTruthTable.getGarbledTruthTable()[0][2];
                return mOutput1;
        }else if (mAnswer1 == mGarbledTruthTable.getGarbledTruthTable()[1][0] &
                mAnswer2 == mGarbledTruthTable.getGarbledTruthTable()[1][1]){
            mOutput1 = mGarbledTruthTable.getGarbledTruthTable()[1][2];
            return mOutput1;
        } else if (mAnswer1 == mGarbledTruthTable.getGarbledTruthTable()[2][0] &
                mAnswer2 == mGarbledTruthTable.getGarbledTruthTable()[2][1]){
            mOutput1 = mGarbledTruthTable.getGarbledTruthTable()[2][2];
            return mOutput1;
        } else if (mAnswer1 == mGarbledTruthTable.getGarbledTruthTable()[3][0] &
                mAnswer2 == mGarbledTruthTable.getGarbledTruthTable()[3][1]){
            mOutput1 = mGarbledTruthTable.getGarbledTruthTable()[3][2];
            return mOutput1;
        } else {
            return  5;
        }
    }

    public GarbledTruthTable getGarbledTruthTable() {
        return mGarbledTruthTable;
    }

    public void setGarbledTruthTable(GarbledTruthTable garbledTruthTable) {
        mGarbledTruthTable = garbledTruthTable;
    }

    public int getAnswer1() {
        return mAnswer1;
    }

    public void setAnswer1(int answer1) {
        mAnswer1 = answer1;
    }

    public int getAnswer2() {
        return mAnswer2;
    }

    public void setAnswer2(int answer2) {
        mAnswer2 = answer2;
    }

    public int getOutput1() {
        return mOutput1;
    }

    public void setOutput1(int output1) {
        mOutput1 = output1;
    }
}
