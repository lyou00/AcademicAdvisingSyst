package com.student.academicadvisingsyst.StudentOp;

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
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterFileStudent;
import com.student.academicadvisingsyst.AdminOP.Adapter.SpinAdapter;
import com.student.academicadvisingsyst.AdminOP.Adapter.SpinrFileAdapter;
import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.View.FileStudentNew;
import com.student.academicadvisingsyst.AdminOP.View.FileStudentView;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelFileStudent;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSemester;
import com.student.academicadvisingsyst.AdminOP.storage.LoginUtils;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.ui.SubjectViewStudent;
import com.student.academicadvisingsyst.databinding.DashborderStudentBinding;
import com.student.academicadvisingsyst.databinding.SemesterStudentListBinding;

import java.util.List;

public class FileStudentSemester extends AppCompatActivity {

    DashborderStudentBinding binding;
    private AdapterFileStudent adapter;
    private ViewModelFileStudent viewModel;

    private ViewModelSemester viewModelS;

    FloatingActionButton fab;
    long fileId;
    String semeterName;


    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DashborderStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent = getIntent();
        fileId = intent.getLongExtra("fileStudentId", 0);
        binding.txtusername.setText(LoginUtils.getInstance(getApplicationContext()).getUserInfoTechar().getName());
        binding.txtaddress.setText(LoginUtils.getInstance(getApplicationContext()).getUserInfoTechar().getStudent().getStudentName());

        binding.textView8.setText("رقم ملفي :"+fileId);
        binding.subjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubjectMy.class);
                intent.putExtra("fileId",+fileId);
                intent.putExtra("op",1);

                startActivity(intent);
            }
        });
        binding.table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SectionTableStudent.class);
                intent.putExtra("fileStudentId",+fileId);

                startActivity(intent);

            }
        });
        binding.Subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubjectViewStudent.class);
                intent.putExtra("fileStudentId",+fileId);

                startActivity(intent);

            }
        });
        binding.attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubjectMy.class);
                intent.putExtra("fileId",+fileId);
                intent.putExtra("op",2);

                startActivity(intent);
            }
        });


        //  getFile(LoginUtils.getInstance(getApplicationContext()).getUserInfoUser().getStudent().getStudentId());
    }
}