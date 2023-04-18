package com.student.academicadvisingsyst.AdminOP.Models;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class UserInfo {
    private static final String TAG = "UserInfo";
    private static final String FILE_NAME = "userInfo";
    private static User defalt = new User();

    public static void set(Context context, User user) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("userId",user.getUserId());
        editor.putString("userName",user.getName());
        editor.putString("userPassword",user.getPassword());
        editor.putString("userAvatard",user.getAvatar());
        Log.i(TAG, "set: " + user);
        editor.apply();
    }

    public static User get(Context context) {
        defalt.setUserId(1);
        defalt.setName("--");
        defalt.setPassword("--");
        defalt.setAvatar("--");

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        User user = new User();
        user.setUserId(sp.getLong("userId",defalt.getUserId()));
        user.setName(sp.getString("userName",defalt.getName()));
        user.setPassword(sp.getString("userPassword",defalt.getPassword()));
        user.setAvatar(sp.getString("userAvatard",defalt.getAvatar()));
       // user.setUserPwd("***");
        Log.i(TAG, "get: " + user);
        return user;
    }
}
