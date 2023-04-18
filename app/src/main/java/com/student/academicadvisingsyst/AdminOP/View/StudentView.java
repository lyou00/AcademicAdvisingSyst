package com.student.academicadvisingsyst.AdminOP.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterStudent;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelStudent;

import java.util.ArrayList;
import java.util.List;

public class StudentView extends AppCompatActivity {

    private AdapterStudent adapter;
    private ViewModelStudent viewModel;
    private ProgressBar progressBar;
    private SearchView searchView;
    private List<Student> students;
    FloatingActionButton fab;
    Spinner spinner2;

    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);
        progressBar= findViewById(R.id.progress_bar);
        spinner2=findViewById(R.id.spinner2);
        List<String> months = new ArrayList<>();
        months.add("Jan");
        months.add("Feb");
        months.add("Mar");
        months.add("Apr");
        months.add("May");
        months.add("Jun");
        months.add("Jul");
        months.add("Aug");
        months.add("Sep");
        months.add("Oct");
        months.add("Nov");
        months.add("Dec");
        ArrayAdapter<String> adapterm = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, months);
        adapterm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapterm);
      //  searchView = binding.searchView;
        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StudentNew.class);
                startActivity(intent);
            }
        });

        viewModel = new ViewModelProvider(this).get(ViewModelStudent.class);
        viewModel.init();
        viewModel.getStudent(this.getApplicationContext(),progressBar);
        setRecycleView();

       viewModel.mutableLiveData.observe(this, new Observer<List<Student>>() {
           @Override
           public void onChanged(List<Student> students) {
               adapter = new AdapterStudent(students,StudentView.this);
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