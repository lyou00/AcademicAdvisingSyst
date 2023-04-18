package com.student.academicadvisingsyst.AdminOP.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterLader;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterTechars;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.Models.Techars;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelTechar;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.databinding.ActivityTeachrNewBinding;
import com.student.academicadvisingsyst.databinding.ActivityTeachrViewBinding;

import java.util.List;

public class LeaderView extends AppCompatActivity {


    private AdapterLader adapter;
    private ViewModelTechar viewModel;
    private ProgressBar progressBar;
    private SearchView searchView;
    private List<Student> students;
    FloatingActionButton fab;

    ActivityTeachrViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTeachrViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.setTitle("مؤشد اكاديمي");
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TecharsNew.class);
                intent.putExtra("type","مرشد");
                intent.putExtra("typeId",2);

                startActivity(intent);
            }
        });

        viewModel = new ViewModelProvider(this).get(ViewModelTechar.class);
        viewModel.init();
        viewModel.getTeaher(this.getApplicationContext(),binding.progressBar,2);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<Techars>>() {
            @Override
            public void onChanged(List<Techars> list) {
                adapter = new AdapterLader(list, LeaderView.this,2);
                binding.recyclerView.setAdapter(adapter);
//                if(!list.isEmpty()) {
//                    adapter.updateList(list);
//                }

            }
        });

    }
    public void setRecycleView(){
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }
}
