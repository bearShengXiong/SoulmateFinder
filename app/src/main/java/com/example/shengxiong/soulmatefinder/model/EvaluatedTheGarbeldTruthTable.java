package com.example.shengxiong.soulmatefinder.model;

/**
 * Created by Shengxiong on 2016/10/26.
 */

public class EvaluatedTheGarbeldTruthTable {
    int mAnswer1;
    int mAnswer2;
    int[][] mInts;
    int mOutput;

    public EvaluatedTheGarbeldTruthTable(int[][] ints, int answer1, int answer2) {
        mInts = ints;
        mAnswer1 = answer1;
        mAnswer2 = answer2;
    }

    public int Eval(){
        if(mAnswer1 == mInts[0][0] && mAnswer2 == mInts[0][1]){
            mOutput = mInts[0][2];
            return mOutput;
        }else  if(mAnswer1 == mInts[1][0] && mAnswer2 == mInts[1][1]){
            mOutput = mInts[1][2];
            return mOutput;
        } else  if(mAnswer1 == mInts[2][0] && mAnswer2 == mInts[2][1]){
            mOutput = mInts[2][2];
            return mOutput;
        } else  if(mAnswer1 == mInts[3][0] && mAnswer2 == mInts[3][1]){
            mOutput = mInts[3][2];
            return mOutput;
        } else {
            return  5;
        }
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

    public int getOutput() {
        return mOutput;
    }

    public void setOutput(int output) {
        mOutput = output;
    }

    public int[][] getInts() {
        return mInts;
    }

    public void setInts(int[][] ints) {
        mInts = ints;
    }
}
