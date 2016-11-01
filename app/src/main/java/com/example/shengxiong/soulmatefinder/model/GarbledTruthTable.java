package com.example.shengxiong.soulmatefinder.model;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Shengxiong on 2016/10/5.
 */

public class GarbledTruthTable implements Serializable {


    Random randomGenerator = new Random();
    int[][] GarbledTruthTable = new int[5][3];

    public Random getRandomGenerator() {
        return randomGenerator;
    }

    public void setRandomGenerator(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public int[][] getGarbledTruthTable() {
        return GarbledTruthTable;
    }

    public void setGarbledTruthTable(int[][] garbledTruthTable) {
        GarbledTruthTable = garbledTruthTable;
    }

    public GarbledTruthTable(Gate gate) {
        GarbledTruthTable[0][0] = gate.getWireInput1().getMinput1();
        GarbledTruthTable[0][1] = gate.getWireInput2().getMinput1();
        if(gate.getTruthTable().getOutput1() == 0){
            GarbledTruthTable[0][2] = gate.getWireOutput1().getMinput1();
        }else {
            GarbledTruthTable[0][2] = gate.getWireOutput1().getMinput2();
        }
        GarbledTruthTable[1][0] = gate.getWireInput1().getMinput1();
        GarbledTruthTable[1][1] = gate.getWireInput2().getMinput2();
        if(gate.getTruthTable().getOutput2() == 0){
            GarbledTruthTable[1][2] = gate.getWireOutput1().getMinput1();
        }else {
            GarbledTruthTable[1][2] = gate.getWireOutput1().getMinput2();
        }
        GarbledTruthTable[2][0] = gate.getWireInput1().getMinput2();
        GarbledTruthTable[2][1] = gate.getWireInput2().getMinput1();
        if(gate.getTruthTable().getOutput3() == 0){
            GarbledTruthTable[2][2] = gate.getWireOutput1().getMinput1();
        }else {
            GarbledTruthTable[2][2] = gate.getWireOutput1().getMinput2();
        }
        GarbledTruthTable[3][0] = gate.getWireInput1().getMinput2();
        GarbledTruthTable[3][1] = gate.getWireInput2().getMinput2();
        if(gate.getTruthTable().getOutput4() == 0){
            GarbledTruthTable[3][2] = gate.getWireOutput1().getMinput1();
        }else {
            GarbledTruthTable[3][2] = gate.getWireOutput1().getMinput2();
        }

    }

    public void permuted(){
        for (int idx = 1; idx <= 3; ++idx){
            int randomInt1 = randomGenerator.nextInt(3);
            int randomInt2 = randomGenerator.nextInt(3);
            GarbledTruthTable[4][0] = GarbledTruthTable[randomInt1][0];
            GarbledTruthTable[4][1] = GarbledTruthTable[randomInt1][1];
            GarbledTruthTable[4][2] = GarbledTruthTable[randomInt1][2];
            GarbledTruthTable[randomInt1][0] = GarbledTruthTable[randomInt2][0];
            GarbledTruthTable[randomInt1][1] = GarbledTruthTable[randomInt2][1];
            GarbledTruthTable[randomInt1][2] = GarbledTruthTable[randomInt2][2];
            GarbledTruthTable[randomInt2][0] = GarbledTruthTable[4][0];
            GarbledTruthTable[randomInt2][1] = GarbledTruthTable[4][1];
            GarbledTruthTable[randomInt2][2] = GarbledTruthTable[4][2];
        }

    }
}
