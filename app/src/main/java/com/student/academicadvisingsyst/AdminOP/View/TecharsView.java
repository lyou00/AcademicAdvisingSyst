package com.student.academicadvisingsyst.AdminOP.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterTechars;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelTechar;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.Models.Techars;
import com.student.academicadvisingsyst.R;

import java.util.List;

public class TecharsView extends AppCompatActivity {


    private AdapterTechars adapter;
    private ViewModelTechar viewModel;
    private ProgressBar progressBar;
    private SearchView searchView;
    private List<Student> students;
    FloatingActionButton fab;
    TextView txtTitel;
    private RecyclerView categoryRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachr_view);
        progressBar= findViewById(R.id.progress_bar);
        txtTitel = findViewById(R.id.txtTitel);
        txtTitel.setText("مدربين ");
        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TecharsNew.class);
                intent.putExtra("type","مدرب");
                intent.putExtra("typeId",1);


                startActivity(intent);
            }
        });

        viewModel = new ViewModelProvider(this).get(ViewModelTechar.class);
        viewModel.init();
        viewModel.getTeaher(this.getApplicationContext(),progressBar,1);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<Techars>>() {
            @Override
            public void onChanged(List<Techars> list) {
                adapter = new AdapterTechars(list, TecharsView.this,1);
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
