package com.student.academicadvisingsyst.AdminOP.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterCourses;
import com.student.academicadvisingsyst.AdminOP.Models.Courses;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelCourses;
import com.student.academicadvisingsyst.R;

import java.util.List;

public class CoursesView extends AppCompatActivity {


    private AdapterCourses adapter;
    private ViewModelCourses viewModel;
    private ProgressBar progressBar;
    private SearchView searchView;
    private List<Courses> courses;
    FloatingActionButton fab;

    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachr_view);
        progressBar= findViewById(R.id.progress_bar);
        //  searchView = binding.searchView;
        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudentNew.class);
                startActivity(intent);
            }
        });

        viewModel = new ViewModelProvider(this).get(ViewModelCourses.class);
        viewModel.init();
        viewModel.getCourses(this.getApplicationContext(),progressBar);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<Courses>>() {
            @Override
            public void onChanged(List<Courses> list) {
                adapter = new AdapterCourses(list, CoursesView.this);
                recyclerView.setAdapter(adapter);
            }
        });

    }
    RecyclerView recyclerView;
    public void setRecycleView(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }
}
