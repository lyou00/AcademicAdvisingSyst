package com.student.academicadvisingsyst.StudentOp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.Models.Subjects;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSection;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSubjects;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterSectionStudentSubject;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterSubjectsStudent;
import com.student.academicadvisingsyst.StudentOp.ui.SubjectViewStudent;
import com.student.academicadvisingsyst.databinding.ActivitySubjectMyBinding;

import java.util.List;

public class SubjectMy extends AppCompatActivity {

    ActivitySubjectMyBinding binding;
    private ViewModelSection viewModel;

    AdapterSectionStudentSubject adapter;
    long fileId;
    Intent intent;
    int op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySubjectMyBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        intent=getIntent();
        fileId=intent.getLongExtra("fileId",0);
        op=intent.getIntExtra("op",0);
        if(op==2){
            binding.txtTitel.setText("اختار المقرر لعرض الحضور");
        }
        viewModel=new ViewModelProvider(this).get(ViewModelSection.class);
        viewModel.init();

        viewModel.getSubjectByFileId(this,binding.progressBar,fileId);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<Section>>() {
            @Override
            public void onChanged(List<Section> subjects) {
                adapter = new AdapterSectionStudentSubject(subjects, SubjectMy.this, op,fileId);
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