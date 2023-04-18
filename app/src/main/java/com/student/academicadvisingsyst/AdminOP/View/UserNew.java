package com.student.academicadvisingsyst.AdminOP.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelTechar;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelUser;
import com.student.academicadvisingsyst.databinding.ActivityTeachrNewBinding;
import com.student.academicadvisingsyst.databinding.AddUserNewBinding;

public class UserNew extends AppCompatActivity {
    private ProgressBar progressBar;

    String res;
    AddUserNewBinding binding;
    private EditText edName,edAddress ,edNation,edUserName,edPhone,edPassword;
    private EditText edDateBr ;
    private EditText etusername ;
    private Button btn_save ;
    Context context;
    private ViewModelUser viewModel;
    Intent intent;
    long ID;
    String type;
    TextView txtName,txtID,txtType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = AddUserNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context=this;
        txtName=binding.txtName;
        txtID=binding.txtId;
        txtType=binding.txtTypeId;
        intent=getIntent();
        ID=intent.getLongExtra("Id",0);
        type=intent.getStringExtra("type");
        txtName.setText(intent.getStringExtra("Name"));
        txtID.setText(ID+"");
        txtType.setText(type);

        btn_save = binding.buttonLogin;
        viewModel = new ViewModelProvider(this).get(ViewModelUser.class);
        viewModel.init();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                res= viewModel.createUser(context,binding);
                Toast.makeText(context, ""+res, Toast.LENGTH_SHORT).show();
                UserNew.this.finish();
            }
        }) ;



    }}
