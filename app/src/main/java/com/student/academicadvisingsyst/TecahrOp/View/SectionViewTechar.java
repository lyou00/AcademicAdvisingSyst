package com.student.academicadvisingsyst.TecahrOp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterSection;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.View.SectionView;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSection;
import com.student.academicadvisingsyst.AdminOP.storage.LoginUtils;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.TecahrOp.AdapterTechar.AdapterSectionTeacher;
import com.student.academicadvisingsyst.databinding.ActivitySectionViewTecharBinding;

import java.util.List;

public class SectionViewTechar extends AppCompatActivity {

    ActivitySectionViewTecharBinding binding;
    ViewModelSection viewModel;
    AdapterSectionTeacher adapter;
    long techarId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySectionViewTecharBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        techarId=LoginUtils.getInstance(getApplicationContext()).getUserInfoUser().getStudent().getStudentId();

        //Toast.makeText(this, "techarId"+techarId, Toast.LENGTH_SHORT).show();
        //binding.txtaddress.setText(LoginUtils.getInstance(getApplicationContext()).getUserInfoUser().getStudent().getStuden
        viewModel = new ViewModelProvider(this).get(ViewModelSection.class);
        viewModel.init();
        viewModel.getSectionTechar(this.getApplicationContext(),binding.progressBar,techarId);
        setRecycleView();

        viewModel.mutableLiveData.observe(this, new Observer<List<Section>>() {
            @Override
            public void onChanged(List<Section> sections) {
                adapter = new AdapterSectionTeacher(sections, SectionViewTechar.this);
                binding.recyclerView.setAdapter(adapter);
               // Toast.makeText(SectionViewTechar.this, "G"+sections.size(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void setRecycleView(){
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this.getApplicationContext(),1));

    }
    }
