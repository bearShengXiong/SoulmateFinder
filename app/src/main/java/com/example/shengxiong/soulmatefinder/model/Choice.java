package com.example.shengxiong.soulmatefinder.model;

/**
 * Created by Shengxiong on 2016/9/28.
 */

public class Choice {
    private String mText;
    private int mNextPage;
    private int mCurrentPage;

    public Choice(String text, int nextPage, int CurrentPage){
        mText = text;
        mNextPage = nextPage;
        mCurrentPage = CurrentPage;
    }

    public int getCurrentPage() {
        return mCurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        mCurrentPage = currentPage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
