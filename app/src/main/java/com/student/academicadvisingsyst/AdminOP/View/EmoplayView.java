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
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterStudent;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelStudent;

import java.util.ArrayList;
import java.util.List;

public class EmoplayView extends AppCompatActivity {
   // ProductFragment fragment;
  //  private FragmentProductBinding binding;
    private AdapterStudent adapter;
    private ViewModelStudent viewModel;
    private ProgressBar progressBar;
    private SearchView searchView;
  //  private CategoryRecyclerAdapter categoryRecyclerAdapter;
    private List<Student> students;
    private List<Student> students2;
    FloatingActionButton fab;

    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view);
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

        viewModel = new ViewModelProvider(this).get(ViewModelStudent.class);
        viewModel.init();
        viewModel.getStudent(this.getApplicationContext(),progressBar);
        setRecycleView();
        //viewModel.mutableLiveData
      //  setCategoryRecycleView();
        students2 = new ArrayList<>();
       viewModel.mutableLiveData.observe(this, new Observer<List<Student>>() {
           @Override
           public void onChanged(List<Student> students) {
               adapter = new AdapterStudent(students, EmoplayView.this);
           recyclerView.setAdapter(adapter);
         //  adapter.updateList(students);
           }
       });
//
//        () -> new Observer<List<Student>>() {
//            @Override
//            public void onChanged(List<Student> products) {
//                adapter = new AdapterStudent(products,StudentView.this);
//                recyclerView.setAdapter(adapter);
////                adapter.updateList(products);
//            }
//        });
//        viewModel.getCategories(getContext().getApplicationContext());
//        // attach setOnQueryTextListener
//        // to search view defined above
//        viewModel.categoryMutableLiveData.observe( new Observer<List<Category>>() {
//            @Override
//            public void onChanged(List<Category> categories) {
//                categoryRecyclerAdapter = new CategoryRecyclerAdapter(categories, fragment, getActivity(),viewModel);
//                binding.categoryRecyclerview.setAdapter(categoryRecyclerAdapter);
////                categoryRecyclerAdapter.updateList(categories);
//
//            }
//        });

    }
    RecyclerView recyclerView;
    public void setRecycleView(){
         recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }
}