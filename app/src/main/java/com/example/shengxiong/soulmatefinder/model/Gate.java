package com.example.shengxiong.soulmatefinder.model;

/**
 * Created by Shengxiong on 2016/9/29.
 */

public class Gate {
    private Wire mWireInput1;
    private Wire mWireInput2;
    private Wire mWireOutput1;
    private TruthTable mTruthTable;


    public Gate(Wire wire1,Wire wire2,Wire wire3, TruthTable truthTable1){
        mWireInput1 = wire1;
        mWireInput2 = wire2;
        mWireOutput1 = wire3;
        mTruthTable = truthTable1;
    }

    public TruthTable getTruthTable() {
        return mTruthTable;
    }

    public void setTruthTable(TruthTable truthTable) {
        mTruthTable = truthTable;
    }

    public Wire getWireInput1() {
        return mWireInput1;
    }

    public void setWireInput1(Wire wireInput1) {
        mWireInput1 = wireInput1;
    }

    public Wire getWireInput2() {
        return mWireInput2;
    }

    public void setWireInput2(Wire wireInput2) {
        mWireInput2 = wireInput2;
    }

    public Wire getWireOutput1() {
        return mWireOutput1;
    }

    public void setWireOutput1(Wire wireOutput1) {
        mWireOutput1 = wireOutput1;
    }

    public int evalTheGate(){

        if (getWireInput1().getChoose() == 0){
            if(getWireInput2().getChoose() == 0){
                getWireOutput1().setChoose(getTruthTable().getOutput1());
                return getWireOutput1().getChoose();
                }else{
                getWireOutput1().setChoose(getTruthTable().getOutput2());
                return getWireOutput1().getChoose();
            }
        }else{
                if(getWireInput2().getChoose() == 0){
                    getWireOutput1().setChoose(getTruthTable().getOutput3());
                    return getWireOutput1().getChoose();
                }else{
                    getWireOutput1().setChoose(getTruthTable().getOutput4());
                    return getWireOutput1().getChoose();
                }
        }



    }
}
