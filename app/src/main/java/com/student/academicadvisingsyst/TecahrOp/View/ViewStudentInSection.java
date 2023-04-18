package com.student.academicadvisingsyst.TecahrOp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterFileStudent;
import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.View.FileStudentView;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelFileStudent;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSection;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSemester;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.TecahrOp.AdapterTechar.AdapterSectionFile;
import com.student.academicadvisingsyst.TecahrOp.AdapterTechar.AdapterSectionTeacher;
import com.student.academicadvisingsyst.databinding.ActivityViewStudentInSectionBinding;

import java.util.List;

public class ViewStudentInSection extends AppCompatActivity {

    ActivityViewStudentInSectionBinding binding;
    private AdapterSectionFile adapter;
    private ViewModelSection viewModel;

    private ViewModelSemester viewModelS;
    Intent intent;
    long sectionId;
    long AttendanceId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityViewStudentInSectionBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        intent=getIntent();
        sectionId=intent.getLongExtra("SectionId",0);
        AttendanceId=intent.getLongExtra("AttendanceId",0);
        Toast.makeText(this, ""+sectionId, Toast.LENGTH_SHORT).show();
        getFileBySection(sectionId);


    }


    public  void getFileBySection(long seid){
        viewModel = new ViewModelProvider(this).get(ViewModelSection.class);
        viewModel.init();
        viewModel.getFileSection(this.getApplicationContext(),binding.progressBar,seid);
        setRecycleView();
        //viewModel.mutableLiveData
        //  setCategoryRecycleView();
        viewModel.mutableLiveData.observe(this, new Observer<List<Section>>() {
            @Override
            public void onChanged(List<Section> fileStudents) {
                adapter = new AdapterSectionFile(fileStudents, ViewStudentInSection.this,AttendanceId);
                binding.recyclerView.setAdapter(adapter);
               // adapter.updateList(fileStudents);
            }
        });
}

    public void setRecycleView(){
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }
}