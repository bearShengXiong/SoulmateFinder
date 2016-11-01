package com.example.shengxiong.soulmatefinder.model;

import java.util.ArrayList;

/**
 * Created by Shengxiong on 2016/10/25.
 */

public class UserData {
    private String user_data;
    private String user_question;
    private ArrayList<String> user_garbled;

    public UserData(String user_data, String user_question, ArrayList<String> user_garbled) {
        this.user_data = user_data;
        this.user_question = user_question;
        this.user_garbled = user_garbled;
    }

    public String getUser_data() {
        return user_data;
    }

    public void setUser_data(String user_data) {
        this.user_data = user_data;
    }

    public String getUser_question() {
        return user_question;
    }

    public void setUser_question(String user_question) {
        this.user_question = user_question;
    }

    public ArrayList<String> getUser_garbled() {
        return user_garbled;
    }

    public void setUser_garbled(ArrayList<String> user_garbled) {
        this.user_garbled = user_garbled;
    }
}
