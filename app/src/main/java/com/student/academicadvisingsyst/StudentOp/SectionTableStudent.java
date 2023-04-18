package com.student.academicadvisingsyst.StudentOp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSection;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterSectionStudent;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterTableSectionStudent;
import com.student.academicadvisingsyst.databinding.ActivitySectionViewStudentBinding;

import java.util.List;

public class SectionTableStudent extends AppCompatActivity {

    ActivitySectionViewStudentBinding binding;
    private AdapterTableSectionStudent adapter;
    Context context;
    private ViewModelSection viewModel;
    Intent intent;

    long fileId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySectionViewStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent=this.getIntent();
        fileId=intent.getLongExtra("fileStudentId",0);



        viewModel = new ViewModelProvider(this).get(ViewModelSection.class);
        viewModel.init();
        viewModel.getSectionTable(this.getApplicationContext(),binding.progressBar,fileId);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<Section>>() {
            @Override
            public void onChanged(List<Section> sections) {

                    adapter =new AdapterTableSectionStudent(sections, SectionTableStudent.this);
                    binding.recyclerView.setAdapter(adapter);


            }
        });


    }
    RecyclerView recyclerView;
    public void setRecycleView(){
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }}