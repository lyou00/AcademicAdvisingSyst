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
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterSubjects;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSubjects;
import com.student.academicadvisingsyst.AdminOP.Models.Subjects;
import com.student.academicadvisingsyst.R;

import java.util.List;

public class SubjectView extends AppCompatActivity {

    private AdapterSubjects adapter;
    private ViewModelSubjects viewModel;
    private ProgressBar progressBar;
    private SearchView searchView;

    FloatingActionButton fab;

    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachr_view);
        progressBar= findViewById(R.id.progress_bar);
        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubjectNew.class);
                startActivity(intent);
            }
        });

        viewModel = new ViewModelProvider(this).get(ViewModelSubjects.class);
        viewModel.init();
        viewModel.getSubject(this.getApplicationContext(),progressBar);
        setRecycleView();

       viewModel.mutableLiveData.observe(this, new Observer<List<Subjects>>() {
           @Override
           public void onChanged(List<Subjects> subjects) {
               adapter = new AdapterSubjects(subjects, SubjectView.this);
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