package com.student.academicadvisingsyst.AdminOP.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterFileStudent;
import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.AdminOP.Models.SemesterNew;
import com.student.academicadvisingsyst.AdminOP.Adapter.SpinAdapter;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelFileStudent;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSemester;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.R;

import java.util.List;

public class FileStudentView extends AppCompatActivity {
    // ProductFragment fragment;
    //  private FragmentProductBinding binding;
    private AdapterFileStudent adapter;
    private ViewModelFileStudent viewModel;

    private ViewModelSemester viewModelS;
    private ProgressBar progressBar;
    private SearchView searchView;
    //  private CategoryRecyclerAdapter categoryRecyclerAdapter;
    private List<Student> students;
    private List<Student> students2;
    FloatingActionButton fab;
    Spinner spinner2;
    SpinAdapter SpinAdapter;
    private RecyclerView categoryRecyclerView;
    long semeterId;
    String semeterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);
        progressBar = findViewById(R.id.progress_bar);
        spinner2 = findViewById(R.id.spinner2);

        //  searchView = binding.searchView;
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FileStudentNew.class);
                intent.putExtra("semesterId",semeterId);
                intent.putExtra("semesterName",semeterName);

                startActivity(intent);
            }
        });

        // spinner2.setAdapter(adapterm);

        viewModelS = new ViewModelProvider(this).get(ViewModelSemester.class);
        viewModelS.getSemestr(this.getApplicationContext(), progressBar);
        viewModelS.mutableLiveData.observe(this, new Observer<List<SemesterNew>>() {
            @Override
            public void onChanged(List<SemesterNew> list) {
                SpinAdapter = new SpinAdapter(FileStudentView.this, android.R.layout.simple_spinner_item, list);
                spinner2.setAdapter(SpinAdapter);
            }
        });


        // You can create an anonymous listener to handle the event when is selected an spinner item
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                SemesterNew user = SpinAdapter.getItem(position);
                getFile(user.getSemesterNewId());
                semeterId=user.getSemesterNewId();
                semeterName=user.getSemesterName();
                // Here you can do the action you want to...
                Toast.makeText(FileStudentView.this, "ID: " + user.getSemesterNewId()
                                + "\nName: " + user.getSemesterName(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {
            }
        });
    }


public  void getFile(long seid){
    viewModel = new ViewModelProvider(this).get(ViewModelFileStudent.class);
    viewModel.init();
    viewModel.getFilwStudentBySemester(this.getApplicationContext(),progressBar,seid);
    setRecycleView();
    //viewModel.mutableLiveData
    //  setCategoryRecycleView();
    viewModel.mutableLiveData.observe(this, new Observer<List<FileStudent>>() {
        @Override
        public void onChanged(List<FileStudent> fileStudents) {
            adapter = new AdapterFileStudent(fileStudents, FileStudentView.this);
            recyclerView.setAdapter(adapter);
           // adapter.updateList(fileStudents);
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