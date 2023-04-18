package com.student.academicadvisingsyst.StudentOp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterDaliySchedule;
import com.student.academicadvisingsyst.AdminOP.Models.DailySchedule;
import com.student.academicadvisingsyst.AdminOP.Models.SubSubjectStudent;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelDailySchedule;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSubSubjectStudent;
import com.student.academicadvisingsyst.databinding.ActivityDailyScheduleViewBinding;

import java.util.ArrayList;
import java.util.List;

public class DailyScheduleStudentView extends AppCompatActivity {

    private AdapterDaliySchedule adapter;
    private ViewModelDailySchedule viewModel;
    private ProgressBar progressBar;
    private SearchView searchView;

    ActivityDailyScheduleViewBinding binding;

    FloatingActionButton fab;

    Intent intent;
    long sectionId;
    long fileid;
    int res;
    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDailyScheduleViewBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        intent=getIntent();
        sectionId=intent.getLongExtra("SectionId",0);
        fileid=intent.getLongExtra("fileId",0);
        binding.txtId.setText("section id"+fileid);
        fileid=intent.getLongExtra("fileId",0);
        res=intent.getIntExtra("res",0);

        if(res==1){
            binding.btsave.setText("تم الاضافة الى جدولك");
            binding.btsave.setEnabled(false);
        }else
        {
            binding.btsave.setEnabled(true);
            binding.btsave.setText("التحاق بالشعبة");

        }

        binding.txtNameSection.setText(intent.getStringExtra("SectionName"));
        binding.txtNameTechar.setText(intent.getStringExtra("TecharName"));
        binding.txtNameSubject.setText(intent.getStringExtra("SubjectName"));
        binding.btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                joinSection();

            }
        });

        viewModel = new ViewModelProvider(this).get(ViewModelDailySchedule.class);
        viewModel.init();
        viewModel.getDailySchelduleBySection(this.getApplicationContext(),binding.progressBar,sectionId);
        setRecycleView();

       viewModel.mutableLiveData.observe(this, new Observer<List<DailySchedule>>() {
           @Override
           public void onChanged(List<DailySchedule> sections) {
               adapter = new AdapterDaliySchedule(sections, DailyScheduleStudentView.this);
             //  dailySchedules.addAll(0,sections);
               //Toast.makeText(getApplicationContext(), "size"+dailySchedules.size(), Toast.LENGTH_SHORT).show();

               binding.recyclerView.setAdapter(adapter);
           }
       });


    }

    ViewModelSubSubjectStudent viewModelSubSubjectStudent;
    DailySchedule subjectStudent=new DailySchedule();
    SubSubjectStudent subSubjectStudent;
    private void joinSection() {
        viewModelSubSubjectStudent = new ViewModelProvider(this).get(ViewModelSubSubjectStudent.class);
        viewModelSubSubjectStudent.init();


            subSubjectStudent=new SubSubjectStudent();

            subSubjectStudent.setFileStudentId(fileid);
            subSubjectStudent.setSectionId(sectionId);
            viewModelSubSubjectStudent.createSection(getApplicationContext(),subSubjectStudent);
            finish();

        }


    RecyclerView recyclerView;
    public void setRecycleView(){
//         recyclerView = findViewById(R.id.recyclerView);
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }
}