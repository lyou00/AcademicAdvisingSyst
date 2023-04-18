package com.student.academicadvisingsyst.AdminOP.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelTechar;
import com.student.academicadvisingsyst.databinding.ActivityTeachrNewBinding;

public class TecharsNew extends AppCompatActivity {
    private ProgressBar progressBar;

    String res;
    ActivityTeachrNewBinding binding;

    Context context;
    private ViewModelTechar viewModel;
    Intent intent;
    String type;
    int typeid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityTeachrNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent =getIntent();
        type=intent.getStringExtra("type");
        typeid=intent.getIntExtra("typeId",0);

        binding.tvTitle.setText(type);
        context=this;
        viewModel = new ViewModelProvider(this).get(ViewModelTechar.class);
        viewModel.init();
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                res= viewModel.create(context,binding,type,typeid);
                Toast.makeText(context, ""+res, Toast.LENGTH_SHORT).show();
                TecharsNew.this.finish();
            }
        }) ;



    }}
