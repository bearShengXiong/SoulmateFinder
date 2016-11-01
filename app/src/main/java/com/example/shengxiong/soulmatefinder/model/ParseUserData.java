package com.example.shengxiong.soulmatefinder.model;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by Shengxiong on 2016/10/25.
 */

public class ParseUserData {
    String[] user_data1;
    int[] user_data;
    String[] user_question1;
    int[][] user_question = new int[5][2];
    ArrayList<String> user_garbled1;
    String [] user_garbled2_1 ;
    String [] user_garbled2_2 ;
    String [] user_garbled2_3 ;
    String [] user_garbled2_4 ;
    String [] user_garbled2_5 ;
    String [] user_garbled2_6 ;
    String [] user_garbled2_7 ;
    String [] user_garbled2_8 ;
    String [] user_garbled2_9 ;
    int [][] user_garbled01 = new int[4][3];
    int [][] user_garbled02 = new int[4][3];
    int [][] user_garbled03 = new int[4][3];
    int [][] user_garbled04 = new int[4][3];
    int [][] user_garbled05 = new int[4][3];
    int [][] user_garbled06 = new int[4][3];
    int [][] user_garbled07 = new int[4][3];
    int [][] user_garbled08 = new int[4][3];
    int [][] user_garbled09 = new int[4][3];

    public ParseUserData(UserData userData) {

        //ParseTheUser_Data
        user_data1 = new String[userData.getUser_data().length()];
        user_data = new int[user_data1.length];
        user_data1 = userData.getUser_data().trim().split("");
        user_data[0] = Integer.parseInt(user_data1[1]);
        user_data[1] = Integer.parseInt(user_data1[2]);
        user_data[2] = Integer.parseInt(user_data1[3]);
        user_data[3] = Integer.parseInt(user_data1[4]);
        user_data[4] = Integer.parseInt(user_data1[5]);


        //ParseTheUser_question
        user_question1 = new String[userData.getUser_question().length()];
        user_question1 = userData.getUser_question().split("");
        user_question[0][0] = Integer.parseInt(user_question1[1]);
        user_question[0][1] = Integer.parseInt(user_question1[2]);
        user_question[1][0] = Integer.parseInt(user_question1[3]);
        user_question[1][1] = Integer.parseInt(user_question1[4]);
        user_question[2][0] = Integer.parseInt(user_question1[5]);
        user_question[2][1] = Integer.parseInt(user_question1[6]);
        user_question[3][0] = Integer.parseInt(user_question1[7]);
        user_question[3][1] = Integer.parseInt(user_question1[8]);
        user_question[4][0] = Integer.parseInt(user_question1[9]);
        user_question[4][1] = Integer.parseInt(user_question1[10]);

        //ParseTheUser_Garbled
        user_garbled1 = userData.getUser_garbled();
        user_garbled2_1 = new String[user_garbled1.get(0).length()];
        user_garbled2_2 = new String[user_garbled1.get(1).length()];
        user_garbled2_3 = new String[user_garbled1.get(2).length()];
        user_garbled2_4 = new String[user_garbled1.get(3).length()];
        user_garbled2_5 = new String[user_garbled1.get(4).length()];
        user_garbled2_6 = new String[user_garbled1.get(5).length()];
        user_garbled2_7 = new String[user_garbled1.get(6).length()];
        user_garbled2_8 = new String[user_garbled1.get(7).length()];
        user_garbled2_9 = new String[user_garbled1.get(8).length()];

        user_garbled2_1 = user_garbled1.get(0).split("");
        user_garbled2_2 = user_garbled1.get(1).split("");
        user_garbled2_3 = user_garbled1.get(2).split("");
        user_garbled2_4 = user_garbled1.get(3).split("");
        user_garbled2_5 = user_garbled1.get(4).split("");
        user_garbled2_6 = user_garbled1.get(5).split("");
        user_garbled2_7 = user_garbled1.get(6).split("");
        user_garbled2_8 = user_garbled1.get(7).split("");
        user_garbled2_9 = user_garbled1.get(8).split("");

        //GarbledTruthTable1
        user_garbled01[0][0] = Integer.parseInt(user_garbled2_1[1]);
        user_garbled01[0][1] = Integer.parseInt(user_garbled2_1[2]);
        user_garbled01[0][2] = Integer.parseInt(user_garbled2_1[3]);
        user_garbled01[1][0] = Integer.parseInt(user_garbled2_1[4]);
        user_garbled01[1][1] = Integer.parseInt(user_garbled2_1[5]);
        user_garbled01[1][2] = Integer.parseInt(user_garbled2_1[6]);
        user_garbled01[2][0] = Integer.parseInt(user_garbled2_1[7]);
        user_garbled01[2][1] = Integer.parseInt(user_garbled2_1[8]);
        user_garbled01[2][2] = Integer.parseInt(user_garbled2_1[9]);
        user_garbled01[3][0] = Integer.parseInt(user_garbled2_1[10]);
        user_garbled01[3][1] = Integer.parseInt(user_garbled2_1[11]);
        user_garbled01[3][2] = Integer.parseInt(user_garbled2_1[12]);

        //GarbledTruthTable2
        user_garbled02[0][0] = Integer.parseInt(user_garbled2_2[1]);
        user_garbled02[0][1] = Integer.parseInt(user_garbled2_2[2]);
        user_garbled02[0][2] = Integer.parseInt(user_garbled2_2[3]);
        user_garbled02[1][0] = Integer.parseInt(user_garbled2_2[4]);
        user_garbled02[1][1] = Integer.parseInt(user_garbled2_2[5]);
        user_garbled02[1][2] = Integer.parseInt(user_garbled2_2[6]);
        user_garbled02[2][0] = Integer.parseInt(user_garbled2_2[7]);
        user_garbled02[2][1] = Integer.parseInt(user_garbled2_2[8]);
        user_garbled02[2][2] = Integer.parseInt(user_garbled2_2[9]);
        user_garbled02[3][0] = Integer.parseInt(user_garbled2_2[10]);
        user_garbled02[3][1] = Integer.parseInt(user_garbled2_2[11]);
        user_garbled02[3][2] = Integer.parseInt(user_garbled2_2[12]);

        //GarbledTruthTable3
        user_garbled03[0][0] = Integer.parseInt(user_garbled2_3[1]);
        user_garbled03[0][1] = Integer.parseInt(user_garbled2_3[2]);
        user_garbled03[0][2] = Integer.parseInt(user_garbled2_3[3]);
        user_garbled03[1][0] = Integer.parseInt(user_garbled2_3[4]);
        user_garbled03[1][1] = Integer.parseInt(user_garbled2_3[5]);
        user_garbled03[1][2] = Integer.parseInt(user_garbled2_3[6]);
        user_garbled03[2][0] = Integer.parseInt(user_garbled2_3[7]);
        user_garbled03[2][1] = Integer.parseInt(user_garbled2_3[8]);
        user_garbled03[2][2] = Integer.parseInt(user_garbled2_3[9]);
        user_garbled03[3][0] = Integer.parseInt(user_garbled2_3[10]);
        user_garbled03[3][1] = Integer.parseInt(user_garbled2_3[11]);
        user_garbled03[3][2] = Integer.parseInt(user_garbled2_3[12]);

        //GarbledTruthTable4
        user_garbled04[0][0] = Integer.parseInt(user_garbled2_4[1]);
        user_garbled04[0][1] = Integer.parseInt(user_garbled2_4[2]);
        user_garbled04[0][2] = Integer.parseInt(user_garbled2_4[3]);
        user_garbled04[1][0] = Integer.parseInt(user_garbled2_4[4]);
        user_garbled04[1][1] = Integer.parseInt(user_garbled2_4[5]);
        user_garbled04[1][2] = Integer.parseInt(user_garbled2_4[6]);
        user_garbled04[2][0] = Integer.parseInt(user_garbled2_4[7]);
        user_garbled04[2][1] = Integer.parseInt(user_garbled2_4[8]);
        user_garbled04[2][2] = Integer.parseInt(user_garbled2_4[9]);
        user_garbled04[3][0] = Integer.parseInt(user_garbled2_4[10]);
        user_garbled04[3][1] = Integer.parseInt(user_garbled2_4[11]);
        user_garbled04[3][2] = Integer.parseInt(user_garbled2_4[12]);

        //GarbledTruthTable5
        user_garbled05[0][0] = Integer.parseInt(user_garbled2_5[1]);
        user_garbled05[0][1] = Integer.parseInt(user_garbled2_5[2]);
        user_garbled05[0][2] = Integer.parseInt(user_garbled2_5[3]);
        user_garbled05[1][0] = Integer.parseInt(user_garbled2_5[4]);
        user_garbled05[1][1] = Integer.parseInt(user_garbled2_5[5]);
        user_garbled05[1][2] = Integer.parseInt(user_garbled2_5[6]);
        user_garbled05[2][0] = Integer.parseInt(user_garbled2_5[7]);
        user_garbled05[2][1] = Integer.parseInt(user_garbled2_5[8]);
        user_garbled05[2][2] = Integer.parseInt(user_garbled2_5[9]);
        user_garbled05[3][0] = Integer.parseInt(user_garbled2_5[10]);
        user_garbled05[3][1] = Integer.parseInt(user_garbled2_5[11]);
        user_garbled05[3][2] = Integer.parseInt(user_garbled2_5[12]);

        //GarbledTruthTable6
        user_garbled06[0][0] = Integer.parseInt(user_garbled2_6[1]);
        user_garbled06[0][1] = Integer.parseInt(user_garbled2_6[2]);
        user_garbled06[0][2] = Integer.parseInt(user_garbled2_6[3]);
        user_garbled06[1][0] = Integer.parseInt(user_garbled2_6[4]);
        user_garbled06[1][1] = Integer.parseInt(user_garbled2_6[5]);
        user_garbled06[1][2] = Integer.parseInt(user_garbled2_6[6]);
        user_garbled06[2][0] = Integer.parseInt(user_garbled2_6[7]);
        user_garbled06[2][1] = Integer.parseInt(user_garbled2_6[8]);
        user_garbled06[2][2] = Integer.parseInt(user_garbled2_6[9]);
        user_garbled06[3][0] = Integer.parseInt(user_garbled2_6[10]);
        user_garbled06[3][1] = Integer.parseInt(user_garbled2_6[11]);
        user_garbled06[3][2] = Integer.parseInt(user_garbled2_6[12]);

        //GarbledTruthTable7
        user_garbled07[0][0] = Integer.parseInt(user_garbled2_7[1]);
        user_garbled07[0][1] = Integer.parseInt(user_garbled2_7[2]);
        user_garbled07[0][2] = Integer.parseInt(user_garbled2_7[3]);
        user_garbled07[1][0] = Integer.parseInt(user_garbled2_7[4]);
        user_garbled07[1][1] = Integer.parseInt(user_garbled2_7[5]);
        user_garbled07[1][2] = Integer.parseInt(user_garbled2_7[6]);
        user_garbled07[2][0] = Integer.parseInt(user_garbled2_7[7]);
        user_garbled07[2][1] = Integer.parseInt(user_garbled2_7[8]);
        user_garbled07[2][2] = Integer.parseInt(user_garbled2_7[9]);
        user_garbled07[3][0] = Integer.parseInt(user_garbled2_7[10]);
        user_garbled07[3][1] = Integer.parseInt(user_garbled2_7[11]);
        user_garbled07[3][2] = Integer.parseInt(user_garbled2_7[12]);

        //GarbledTruthTable8
        user_garbled08[0][0] = Integer.parseInt(user_garbled2_8[1]);
        user_garbled08[0][1] = Integer.parseInt(user_garbled2_8[2]);
        user_garbled08[0][2] = Integer.parseInt(user_garbled2_8[3]);
        user_garbled08[1][0] = Integer.parseInt(user_garbled2_8[4]);
        user_garbled08[1][1] = Integer.parseInt(user_garbled2_8[5]);
        user_garbled08[1][2] = Integer.parseInt(user_garbled2_8[6]);
        user_garbled08[2][0] = Integer.parseInt(user_garbled2_8[7]);
        user_garbled08[2][1] = Integer.parseInt(user_garbled2_8[8]);
        user_garbled08[2][2] = Integer.parseInt(user_garbled2_8[9]);
        user_garbled08[3][0] = Integer.parseInt(user_garbled2_8[10]);
        user_garbled08[3][1] = Integer.parseInt(user_garbled2_8[11]);
        user_garbled08[3][2] = Integer.parseInt(user_garbled2_8[12]);

        //GarbledTruthTable9
        user_garbled09[0][0] = Integer.parseInt(user_garbled2_9[1]);
        user_garbled09[0][1] = Integer.parseInt(user_garbled2_9[2]);
        user_garbled09[0][2] = Integer.parseInt(user_garbled2_9[3]);
        user_garbled09[1][0] = Integer.parseInt(user_garbled2_9[4]);
        user_garbled09[1][1] = Integer.parseInt(user_garbled2_9[5]);
        user_garbled09[1][2] = Integer.parseInt(user_garbled2_9[6]);
        user_garbled09[2][0] = Integer.parseInt(user_garbled2_9[7]);
        user_garbled09[2][1] = Integer.parseInt(user_garbled2_9[8]);
        user_garbled09[2][2] = Integer.parseInt(user_garbled2_9[9]);
        user_garbled09[3][0] = Integer.parseInt(user_garbled2_9[10]);
        user_garbled09[3][1] = Integer.parseInt(user_garbled2_9[11]);
        user_garbled09[3][2] = Integer.parseInt(user_garbled2_9[12]);
    }

    public int[] getUser_data() {
        return user_data;
    }

    public void setUser_data(int[] user_data) {
        this.user_data = user_data;
    }

    public int[][] getUser_question() {
        return user_question;
    }

    public void setUser_question(int[][] user_question) {
        this.user_question = user_question;
    }

    public int[][] getUser_garbled01() {
        return user_garbled01;
    }

    public void setUser_garbled01(int[][] user_garbled01) {
        this.user_garbled01 = user_garbled01;
    }

    public int[][] getUser_garbled02() {
        return user_garbled02;
    }

    public void setUser_garbled02(int[][] user_garbled02) {
        this.user_garbled02 = user_garbled02;
    }

    public int[][] getUser_garbled03() {
        return user_garbled03;
    }

    public void setUser_garbled03(int[][] user_garbled03) {
        this.user_garbled03 = user_garbled03;
    }

    public int[][] getUser_garbled04() {
        return user_garbled04;
    }

    public void setUser_garbled04(int[][] user_garbled04) {
        this.user_garbled04 = user_garbled04;
    }

    public int[][] getUser_garbled05() {
        return user_garbled05;
    }

    public void setUser_garbled05(int[][] user_garbled05) {
        this.user_garbled05 = user_garbled05;
    }

    public int[][] getUser_garbled06() {
        return user_garbled06;
    }

    public void setUser_garbled06(int[][] user_garbled06) {
        this.user_garbled06 = user_garbled06;
    }

    public int[][] getUser_garbled07() {
        return user_garbled07;
    }

    public void setUser_garbled07(int[][] user_garbled07) {
        this.user_garbled07 = user_garbled07;
    }

    public int[][] getUser_garbled08() {
        return user_garbled08;
    }

    public void setUser_garbled08(int[][] user_garbled08) {
        this.user_garbled08 = user_garbled08;
    }

    public int[][] getUser_garbled09() {
        return user_garbled09;
    }

    public void setUser_garbled09(int[][] user_garbled09) {
        this.user_garbled09 = user_garbled09;
    }
}
