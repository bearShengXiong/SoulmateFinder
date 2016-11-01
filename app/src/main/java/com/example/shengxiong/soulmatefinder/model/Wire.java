package com.example.shengxiong.soulmatefinder.model;

import java.util.Random;

/**
 * Created by Shengxiong on 2016/9/29.
 */

public class Wire {
    private int minput1;
    private int minput2;
    private int mChoose;
    private int mChooseGarbled;
    Random randomGenerator = new Random();

    public Wire(int key1,int key2, int answer, int answerGarbled){
        minput1 = key1;
        minput2 = key2;
        mChoose = answer;
        mChooseGarbled = answerGarbled;
    }

    public int getChooseGarbled() {
        return mChooseGarbled;
    }

    public void setChooseGarbled(int chooseGarbled) {
        mChooseGarbled = chooseGarbled;
    }

    public int getMinput1() {
        return minput1;
    }

    public void setMinput1(int minput1) {
        this.minput1 = minput1;
    }

    public int getMinput2() {
        return minput2;
    }

    public void setMinput2(int minput2) {
        this.minput2 = minput2;
    }

    public int getChoose() {
        return mChoose;
    }

    public void setChoose(int choose) {
        mChoose = choose;
    }

    public void randomGenerateTwoKEys(){
       int randomInt1 = randomGenerator.nextInt(2);
        minput1 = randomInt1;
        if(minput1 == 1){
            minput2 = 0;
        }else {
            minput2 = 1;
        }
    }
}
