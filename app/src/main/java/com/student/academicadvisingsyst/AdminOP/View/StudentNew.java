package com.student.academicadvisingsyst.AdminOP.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelStudent;
import com.student.academicadvisingsyst.databinding.AddStudentBinding;

public class StudentNew extends AppCompatActivity {
    private ProgressBar progressBar;

    String res;
    AddStudentBinding addStudentBinding;
    private EditText edName,edAddress ,edNation,edUserName,edPhone,edPassword;
    private EditText edDateBr ;
    private EditText etusername ;
    private Button btn_save ;
    Context context;
    private ViewModelStudent viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addStudentBinding = AddStudentBinding.inflate(getLayoutInflater());
        setContentView(addStudentBinding.getRoot());
        context=this;
        btn_save = addStudentBinding.btnSave;
        viewModel = new ViewModelProvider(this).get(ViewModelStudent.class);
        viewModel.init();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                res= viewModel.createStudent(context,addStudentBinding);
                Toast.makeText(context, ""+res, Toast.LENGTH_SHORT).show();
                StudentNew.this.finish();
            }
        }) ;



    }
}