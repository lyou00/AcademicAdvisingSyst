package com.student.academicadvisingsyst.AdminOP.View;

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
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.databinding.ActivityDailyScheduleBinding;
import com.student.academicadvisingsyst.databinding.ActivityDailyScheduleViewBinding;

import java.util.ArrayList;
import java.util.List;

public class DailyScheduleView extends AppCompatActivity {

    private AdapterDaliySchedule adapter;
    private ViewModelDailySchedule viewModel;
    private ProgressBar progressBar;
    private SearchView searchView;

    ActivityDailyScheduleViewBinding binding;

    FloatingActionButton fab;

    List<DailySchedule> dailySchedules=new ArrayList<>();
    Intent intent;
    long sectionId;
    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDailyScheduleViewBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        intent=getIntent();
        binding.txtId.setText("section id"+intent.getLongExtra("SectionId",0));
        sectionId=intent.getLongExtra("SectionId",0);
        binding.txtNameSection.setText(intent.getStringExtra("SectionName"));
        binding.txtNameTechar.setText(intent.getStringExtra("TecharName"));
        binding.txtNameSubject.setText(intent.getStringExtra("SubjectName"));
        binding.btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SectionNew.class);
                startActivity(intent);

            }
        });

        viewModel = new ViewModelProvider(this).get(ViewModelDailySchedule.class);
        viewModel.init();
        viewModel.getDailySchelduleBySection(this.getApplicationContext(),binding.progressBar,sectionId);
        setRecycleView();

       viewModel.mutableLiveData.observe(this, new Observer<List<DailySchedule>>() {
           @Override
           public void onChanged(List<DailySchedule> sections) {
               adapter = new AdapterDaliySchedule(sections, DailyScheduleView.this);
               binding.recyclerView.setAdapter(adapter);
           }
       });


    }
    ViewModelSubSubjectStudent viewModelSubSubjectStudent;
 DailySchedule subjectStudent=new DailySchedule();
 SubSubjectStudent subSubjectStudent;
    private void getList() {
        viewModelSubSubjectStudent = new ViewModelProvider(this).get(ViewModelSubSubjectStudent.class);
        viewModelSubSubjectStudent.init();
        for (int i = 0; i <dailySchedules.size(); i++) {
            subjectStudent=dailySchedules.get(i);

            subSubjectStudent=new SubSubjectStudent();
            subSubjectStudent.setDailyScheduleId(dailySchedules.get(i).getDailyScheduleId());

            subSubjectStudent.setFileStudentId(1);
            viewModelSubSubjectStudent.createSection(getApplicationContext(),subSubjectStudent);

        }
    }

    RecyclerView recyclerView;
    public void setRecycleView(){
//         recyclerView = findViewById(R.id.recyclerView);
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }
}