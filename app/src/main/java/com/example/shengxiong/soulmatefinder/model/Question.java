package com.example.shengxiong.soulmatefinder.model;

import com.example.shengxiong.soulmatefinder.R;

/**
 * Created by Shengxiong on 2016/9/28.
 */

public class Question {
    private Page[] mPages;

    public Question(){
        mPages = new Page[7];
        mPages[0] =new Page(
                R.mipmap.page0,
                "Are you male or female?",
                new Choice("MALE",1,0),
                new Choice("FEMALE",1,0)
                );
        mPages[1] =new Page(
                R.mipmap.page1,
                "Do you like coffee?",
                new Choice("NO",2,1),
                new Choice("YES",2,1)
        );
        mPages[2] =new Page(
                R.mipmap.page2,
                "Do you like watch movie?",
                new Choice("NO",3,2),
                new Choice("YES",3,2)
        );
        mPages[3] =new Page(
                R.mipmap.page3,
                "Do you like NBA?",
                new Choice("NO",4,3),
                new Choice("YES",4,3)
        );
        mPages[4] =new Page(
                R.mipmap.page4,
                "Do you like to do exercise with your partner?",
                new Choice("NO",5,4),
                new Choice("YES",5,4)
        );
        mPages[5] =new Page(
                R.mipmap.page5,
                "Are you ready for your results?"
                );


    }

    public Page getPage(int pageNumber){
        return mPages[pageNumber];
    }
}
