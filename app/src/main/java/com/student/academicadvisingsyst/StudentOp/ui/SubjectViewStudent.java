package com.student.academicadvisingsyst.StudentOp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterSubjects;
import com.student.academicadvisingsyst.AdminOP.Models.Subjects;
import com.student.academicadvisingsyst.AdminOP.View.SubjectView;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSubjects;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterSubjectsStudent;
import com.student.academicadvisingsyst.databinding.ActivitySubjectViewStudentBinding;

import java.util.List;

public class SubjectViewStudent extends AppCompatActivity {

    private AdapterSubjectsStudent adapter;
    private ViewModelSubjects viewModel;

    Intent intent;
    long fileId;
    ActivitySubjectViewStudentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySubjectViewStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent = getIntent();
        fileId = intent.getLongExtra("fileStudentId", 0);
        binding.txtTitel.setText(binding.txtTitel.getText()+"رقم ملفي"+fileId);
        viewModel = new ViewModelProvider(this).get(ViewModelSubjects.class);
        viewModel.init();
        viewModel.getSubject(this.getApplicationContext(),binding.progressBar);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<Subjects>>() {
            @Override
            public void onChanged(List<Subjects> subjects) {
                adapter = new AdapterSubjectsStudent(subjects,SubjectViewStudent.this, 1,fileId);
                binding.recyclerView.setAdapter(adapter);
            }
        });


    }
    RecyclerView recyclerView;
    public void setRecycleView(){
       // recyclerView = findViewById(R.id.recyclerView);
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }
    }
