package com.student.academicadvisingsyst.AdminOP.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.student.academicadvisingsyst.AdminOP.Models.Techars;
import com.student.academicadvisingsyst.databinding.LeaderDetailsBinding;
import com.student.academicadvisingsyst.databinding.TecharDetailsBinding;

public class TecherDetails extends AppCompatActivity {

    TecharDetailsBinding binding;
    LeaderDetailsBinding bindingl;
    Techars techars = new Techars();
    TextView txtName,txtAdd,txtPhone;
    String type;
    long techerId;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


         intent=getIntent();
        techerId= intent.getLongExtra("TecharId",0);

        type=(intent.getStringExtra("TypeChar"));
//        txtName.setText(intent.getStringExtra("Sex"));
//        txtName.setText(intent.getStringExtra("NationalId"));


//
//        intent.putExtra("TypeChar",mylists.get(position).getTypeChar());
//        intent.putExtra("",mylists.get(position).getTecharName());
//        intent.putExtra("TecharPhone",mylists.get(position).getTecharPhone());
//        intent.putExtra("TecharAddress",mylists.get(position).getTecharAddress());
//        intent.putExtra("Specialization",mylists.get(position).getSpecialization());
//        intent.putExtra("Sex",mylists.get(position).getSex());
//        intent.putExtra("NationalId",mylists.get(position).getNationalId());
//        intent.putExtra("Note",mylists.get(position).getNote());

//        Bundle b = this.getIntent().getExtras();
//        if (b != null) {
//            techars = (Techars) b.getSerializable("techar");
//        }


        Toast.makeText(this, ""+type, Toast.LENGTH_SHORT).show();

        if(type.equals("مدرب")){
            layoutBindingTeacher();
        }else  if(type.equals("مرشد")){
            layoutBindingLeader();
        }

    }



    public  void layoutBindingTeacher()
    {
        binding=TecharDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        txtName=binding.txtusername;
        txtAdd=binding.txtaddress;
        txtPhone=binding.txtphone;


        //Toast.makeText(this, ""+techars.getTecharName(), Toast.LENGTH_SHORT).show();
        txtName.setText(intent.getStringExtra("TecharName"));
        txtPhone.setText(intent.getStringExtra("TecharPhone"));
        txtAdd.setText(intent.getStringExtra("TecharAddress"));
    }

    public  void layoutBindingLeader()
    {
        bindingl=LeaderDetailsBinding.inflate(getLayoutInflater());
        setContentView(bindingl.getRoot());
        txtName=bindingl.txtusername;
        txtAdd=bindingl.txtaddress;
        txtPhone=bindingl.txtphone;


        //Toast.makeText(this, ""+techars.getTecharName(), Toast.LENGTH_SHORT).show();
        txtName.setText(intent.getStringExtra("TecharName"));
        txtPhone.setText(intent.getStringExtra("TecharPhone"));
        txtAdd.setText(intent.getStringExtra("TecharAddress"));
    }
}