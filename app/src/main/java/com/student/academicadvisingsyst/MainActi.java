package com.student.academicadvisingsyst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.widget.Button;

import com.student.academicadvisingsyst.AdminOP.View.ui.LoginActivity;
import com.student.academicadvisingsyst.databinding.ActivityMainBinding;

public class MainActi extends AppCompatActivity {

    public Button button;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        button = binding.button;
        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });

    }
}