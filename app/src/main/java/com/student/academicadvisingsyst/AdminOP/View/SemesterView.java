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
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterSemester;
import com.student.academicadvisingsyst.AdminOP.Models.SemesterNew;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSemester;
import com.student.academicadvisingsyst.R;

import java.util.List;

public class SemesterView extends AppCompatActivity {


    private AdapterSemester adapter;
    private ViewModelSemester viewModel;
    private ProgressBar progressBar;
    private SearchView searchView;
    private List<SemesterNew> courses;
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

        viewModel = new ViewModelProvider(this).get(ViewModelSemester.class);
        viewModel.init();
        viewModel.getSemestr(this.getApplicationContext(),progressBar);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<SemesterNew>>() {
            @Override
            public void onChanged(List<SemesterNew> list) {
                adapter = new AdapterSemester(list, SemesterView.this);
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
