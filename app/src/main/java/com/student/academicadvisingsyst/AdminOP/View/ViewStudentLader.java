package com.student.academicadvisingsyst.AdminOP.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterFileStudent;
import com.student.academicadvisingsyst.AdminOP.Adapter.SpinAdapter;
import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.AdminOP.Models.SemesterNew;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelFileStudent;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSemester;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.databinding.ActivityViewStudentLaderBinding;

import java.util.List;

public class ViewStudentLader extends AppCompatActivity {
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
    long teachrId;
    String Name;
    ActivityViewStudentLaderBinding  binding;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityViewStudentLaderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        intent=getIntent();
        teachrId=intent.getLongExtra("Id",0);

        Name=intent.getStringExtra("Name");
        Toast.makeText(this, ""+teachrId, Toast.LENGTH_SHORT).show();
        getFile(teachrId);
        //  searchView = binding.searchView;
            binding.fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), LaderFileStudentNew.class);
                    intent.putExtra("idlader",teachrId);
                    intent.putExtra("namelader",Name);

                    startActivity(intent);
                }
            });


        }


        public  void getFile(long id){
            viewModel = new ViewModelProvider(this).get(ViewModelFileStudent.class);
            viewModel.init();
            viewModel.getFilwStudentBylader(this.getApplicationContext(),binding.progressBar,id);
            setRecycleView();
            //viewModel.mutableLiveData
            //  setCategoryRecycleView();
            viewModel.mutableLiveData.observe(this, new Observer<List<FileStudent>>() {
                @Override
                public void onChanged(List<FileStudent> fileStudents) {
                    adapter = new AdapterFileStudent(fileStudents, ViewStudentLader.this);
                    binding.recyclerView.setAdapter(adapter);
                    // adapter.updateList(fileStudents);
                }
            });
        }


        RecyclerView recyclerView;
        public void setRecycleView(){
            binding.recyclerView.setHasFixedSize(false);
            binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

        }
    }
