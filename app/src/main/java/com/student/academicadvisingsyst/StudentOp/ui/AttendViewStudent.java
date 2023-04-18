package com.student.academicadvisingsyst.StudentOp.ui;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterSection;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.View.SectionView;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSection;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterSectionAttend;
import com.student.academicadvisingsyst.databinding.ActivityAttendViewStudentBinding;

import java.util.List;

public class AttendViewStudent extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
private ActivityAttendViewStudentBinding binding;
    private AdapterSectionAttend adapter;
    private ViewModelSection viewModel;
    Intent intent;
    long subid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAttendViewStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

intent=getIntent();
        subid=intent.getLongExtra("SubSubjectId",0);
        viewModel = new ViewModelProvider(this).get(ViewModelSection.class);
        viewModel.init();
        viewModel.getSectionByAttend(this.getApplicationContext(),binding.progressBar,subid);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<Section>>() {
            @Override
            public void onChanged(List<Section> sections) {
                adapter = new AdapterSectionAttend(sections, AttendViewStudent.this);
                binding.recyclerView.setAdapter(adapter);
            }
        });


    }
    public void setRecycleView(){
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }

    }
