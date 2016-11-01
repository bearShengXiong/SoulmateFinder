package com.example.shengxiong.soulmatefinder.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shengxiong.soulmatefinder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengxiong on 2016/11/1.
 */

public class UserInfoAdapter extends ArrayAdapter {

    List mList = new ArrayList();
    public UserInfoAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(UserInfo object) {

        super.add(object);
        mList.add(object);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row = convertView;
        UserInfoHolder mUserInfoHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.user_info,parent,false);
            mUserInfoHolder = new UserInfoHolder();
            mUserInfoHolder.user_name = (TextView) row.findViewById(R.id.user_name);
            mUserInfoHolder.user_email = (TextView) row.findViewById(R.id.user_email);
            row.setTag(mUserInfoHolder);
        }else{
            mUserInfoHolder = (UserInfoHolder) row.getTag();
        }
        UserInfo mUserInfo = (UserInfo) this.getItem(position);
        mUserInfoHolder.user_name.setText(mUserInfo.getName());
        mUserInfoHolder.user_email.setText(mUserInfo.getEmail());
        return row;
    }

    static class UserInfoHolder{
        TextView user_name, user_email;

    }
}
