package com.example.shengxiong.soulmatefinder.model;

import java.util.ArrayList;

/**
 * Created by Shengxiong on 2016/10/19.
 */

public class GarbledCircuit {
    private ArrayList<GarbledEval> mGarbledEvalArrayList;

    private  int mOutput;
    public GarbledCircuit(ArrayList<GarbledEval> garbledEvals) {
        mGarbledEvalArrayList = garbledEvals;

    }
    public int evalGarbledCircuit(){
        for (GarbledEval garbledEval : mGarbledEvalArrayList) {
            garbledEval.eval();
            mOutput = garbledEval.eval();
        }
        return mOutput;
    }

}
