package com.student.academicadvisingsyst.AdminOP.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.databinding.ActivityStudentDetailsBinding;

public class StudentDetails extends AppCompatActivity {

    ActivityStudentDetailsBinding binding;

    TextView txtName,txtAdd,txtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityStudentDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        txtName=binding.txtusername;
        txtAdd=binding.txtaddress;
        txtPhone=binding.txtphone;
        Student techars = null;
        Bundle b = this.getIntent().getExtras();
        if (b != null)
            techars= (Student) b.getSerializable("student");
        Toast.makeText(this, ""+techars.getStudentName(), Toast.LENGTH_SHORT).show();
        txtName.setText(techars.getStudentName());
        txtAdd.setText(techars.getStudentAdderss());
        txtPhone.setText(techars.getStudentPhone());

    }
}