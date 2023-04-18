package com.student.academicadvisingsyst.TecahrOp;

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
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.Models.SubSubjectStudent;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelDailySchedule;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSubSubjectStudent;
import com.student.academicadvisingsyst.TecahrOp.AdapterTechar.AdapterDaliyScheduleTechar;
import com.student.academicadvisingsyst.databinding.ActivityDailyScheduleViewBinding;

import java.util.ArrayList;
import java.util.List;

public class DailyScheduleInTecharView extends AppCompatActivity {

    private AdapterDaliyScheduleTechar adapter;
    private ViewModelDailySchedule viewModel;
    private ProgressBar progressBar;
    private SearchView searchView;

    ActivityDailyScheduleViewBinding binding;

    FloatingActionButton fab;

    List<DailySchedule> dailySchedules=new ArrayList<>();
    Intent intent;
    long sectionId;
    private RecyclerView categoryRecyclerView;
    Section section=new Section();

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
        section.setSectionName(intent.getStringExtra("SectionName"));
        section.setSubjectNameAr(intent.getStringExtra("SubjectName"));

        section.setSectionId(sectionId);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), SectionNew.class);
//                startActivity(intent);
                //getList();

            }
        });

        viewModel = new ViewModelProvider(this).get(ViewModelDailySchedule.class);
        viewModel.init();
        viewModel.getDailySchelduleBySection(this.getApplicationContext(),binding.progressBar,sectionId);
        setRecycleView();

       viewModel.mutableLiveData.observe(this, new Observer<List<DailySchedule>>() {
           @Override
           public void onChanged(List<DailySchedule> dailySchedules) {
               adapter = new AdapterDaliyScheduleTechar(dailySchedules, DailyScheduleInTecharView.this,section);
               //dailySchedules.addAll(0,sections);
             //  Toast.makeText(getApplicationContext(), "size"+dailySchedules.size(), Toast.LENGTH_SHORT).show();

               binding.recyclerView.setAdapter(adapter);
           }
       });


    }
    ViewModelSubSubjectStudent viewModelSubSubjectStudent;
 DailySchedule subjectStudent=new DailySchedule();
 SubSubjectStudent subSubjectStudent;
//    private void getList() {
//        Toast.makeText(this, "jkkjhhjkhk"+dailySchedules.size(), Toast.LENGTH_SHORT).show();
//        viewModelSubSubjectStudent = new ViewModelProvider(this).get(ViewModelSubSubjectStudent.class);
//        viewModelSubSubjectStudent.init();
//        for (int i = 0; i <dailySchedules.size(); i++) {
//            subjectStudent=dailySchedules.get(i);
//
//            subSubjectStudent=new SubSubjectStudent();
//            subSubjectStudent.setDailyScheduleId(dailySchedules.get(i).getDailyScheduleId());
//
//            subSubjectStudent.setFileStudentId(1);
//            viewModelSubSubjectStudent.createSection(getApplicationContext(),subSubjectStudent);
//
//        }
//    }

    RecyclerView recyclerView;
    public void setRecycleView(){
//         recyclerView = findViewById(R.id.recyclerView);
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }
}