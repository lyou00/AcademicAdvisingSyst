package com.student.academicadvisingsyst.TecahrOp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.Models.Attendance;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelAttendance;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSection;
import com.student.academicadvisingsyst.AdminOP.storage.LoginUtils;
import com.student.academicadvisingsyst.TecahrOp.AdapterTechar.AdapterAttendce;
import com.student.academicadvisingsyst.TecahrOp.AdapterTechar.AdapterSectionTeacher;
import com.student.academicadvisingsyst.databinding.ActivityAttendanceViewBinding;

import java.util.List;

public class AttendanceView extends AppCompatActivity {

    ActivityAttendanceViewBinding binding;
    ViewModelAttendance viewModel;
    AdapterAttendce adapter;
    long dailyId;
    Intent intent;
    long sectionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityAttendanceViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent=getIntent();
       dailyId=   intent.getLongExtra("DailyScheduleId",0);
        sectionId= intent.getLongExtra("SectionId",0);

        binding.txtDailyId.setText(intent.getLongExtra("DailyScheduleId",0)+"");
        binding.txtTimeOf.setText(intent.getStringExtra("TimeOf"));
        binding.txtTimeTo.setText(intent.getStringExtra("TimeTo"));
        binding.txtNameday.setText(intent.getStringExtra("DayName"));


        viewModel = new ViewModelProvider(this).get(ViewModelAttendance.class);
        viewModel.init();
        viewModel.getAttendanceByDailyId(this.getApplicationContext(),binding.progressBar,dailyId);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<Attendance>>() {
            @Override
            public void onChanged(List<Attendance> sections) {
                adapter = new AdapterAttendce(sections, AttendanceView.this,sectionId);
                binding.recyclerView.setAdapter(adapter);
//                Toast.makeText(AttendanceView.this, "G"+sections.size(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),AttendanceNew.class);
                intent.putExtra("DailyScheduleId",dailyId);
                intent.putExtra("TimeOf",binding.txtTimeOf.getText().toString());
                intent.putExtra("TimeTo",binding.txtTimeTo.getText().toString());


                intent.putExtra("DayName",binding.txtNameday.getText().toString());
                startActivity(intent);

            }
        });


    }
    public void setRecycleView(){
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }
}
