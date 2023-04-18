package com.student.academicadvisingsyst.StudentOp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterSection;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterSubjects;
import com.student.academicadvisingsyst.AdminOP.Adapter.SpinrTecharAdapter;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.View.SectionNew;
import com.student.academicadvisingsyst.AdminOP.View.SectionView;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSection;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterSectionStudent;
import com.student.academicadvisingsyst.databinding.ActivitySectionViewStudentBinding;

import java.util.List;

public class SectionViewStudent extends AppCompatActivity {

    ActivitySectionViewStudentBinding binding;
    private AdapterSectionStudent adapter;
    Context context;
    private ViewModelSection viewModel;
    Intent intent;
    long subjectId;
    String SubjectName;
    long fileId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySectionViewStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent=this.getIntent();
        subjectId=intent.getLongExtra("subjectId",0);
        fileId=intent.getLongExtra("fileId",0);
        this.setTitle("الشعب"+fileId);

        Toast.makeText(getApplicationContext(), ""+subjectId, Toast.LENGTH_SHORT).show();
        SubjectName=intent.getStringExtra("SubjectName");
        Toast.makeText(getApplicationContext(), ""+SubjectName, Toast.LENGTH_SHORT).show();


        viewModel = new ViewModelProvider(this).get(ViewModelSection.class);
        viewModel.init();
        viewModel.getSectionBySubjectId(this.getApplicationContext(),binding.progressBar,subjectId,fileId);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<Section>>() {
            @Override
            public void onChanged(List<Section> sections) {

                    adapter =new AdapterSectionStudent(sections, SectionViewStudent.this,1,fileId);
                    binding.recyclerView.setAdapter(adapter);


            }
        });


    }
    RecyclerView recyclerView;
    public void setRecycleView(){
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }}