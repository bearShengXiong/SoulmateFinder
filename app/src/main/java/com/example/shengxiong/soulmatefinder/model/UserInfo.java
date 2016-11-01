package com.example.shengxiong.soulmatefinder.model;

/**
 * Created by Shengxiong on 2016/11/1.
 */

public class UserInfo {
    private String mName,mEmail;

    public UserInfo(String name, String email) {
        mName = name;
        mEmail = email;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }
}
