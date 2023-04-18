package com.student.academicadvisingsyst.AdminOP.View;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.student.academicadvisingsyst.AdminOP.Models.User;
import com.student.academicadvisingsyst.AdminOP.View.ui.LoginActivity;
import com.student.academicadvisingsyst.AdminOP.storage.LoginUtils;
import com.student.academicadvisingsyst.MainActivity;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.FileStudentSemester;
import com.student.academicadvisingsyst.StudentOp.MainStudent;
import com.student.academicadvisingsyst.TecahrOp.MainTechar;


public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 1000;

    User user=new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loadLocale(this);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            user=LoginUtils.getInstance(SplashActivity.this).getUserInfo();
            if(LoginUtils.getInstance(SplashActivity.this).isLoggedIn()) {
                if(user.getUsertupe().equals("متدرب")){
                        Intent i = new Intent(SplashActivity.this, MainStudent.class);
                        startActivity(i);}
                else if(user.getUsertupe().equals("مدرب")){
                        Intent i = new Intent(SplashActivity.this, MainTechar.class);
                        startActivity(i);
            }else{
                        Intent i = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(i);
            }}


            // Close this activity
            finish();
            // If user does not log in before, go to LoginActivity
            if(!LoginUtils.getInstance(SplashActivity.this).isLoggedIn()) {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        }, SPLASH_TIME_OUT);
    }
}
