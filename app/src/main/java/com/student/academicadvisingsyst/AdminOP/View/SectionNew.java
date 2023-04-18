package com.student.academicadvisingsyst.AdminOP.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterSubjects;
import com.student.academicadvisingsyst.AdminOP.Adapter.SpinrTecharAdapter;
import com.student.academicadvisingsyst.AdminOP.Adapter.SubjectAdapter;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.Models.Subjects;
import com.student.academicadvisingsyst.AdminOP.Models.Techars;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSection;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSubjects;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelTechar;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.databinding.SectionNewBinding;

import java.util.List;

public class SectionNew extends AppCompatActivity {
    private ProgressBar progressBar;

    String res;
  SectionNewBinding binding;

    //AddSectionNewBinding binding;
    SubjectAdapter subjectAdapter;
    AdapterSubjects subjects;
    SpinrTecharAdapter techarAdapter;
    Context context;

    private ViewModelSection viewModelSection;
    private ViewModelSubjects viewModel;

    private ViewModelTechar viewModelTechar;


    int demndId;
    Intent  intent;
    long subID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = SectionNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context=this;
   // getSubjectId();
        intent=getIntent();
        subID=intent.getLongExtra("subjectId",0);
        section.setSubjectId(subID);



        getTechar();
      //  getSubjectId();;

        // on below line we are adding check change listener for our radio group.
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // on below line we are getting radio button from our group.
                RadioButton radioButton = findViewById(checkedId);

                if (radioButton.getText().equals("نظري")) {
                    section.setSectionType((String) radioButton.getText());

                    //   spinner.setVisibility(View.VISIBLE);
                } else if (radioButton.getText().equals("عملي"))
                    {
                        section.setSectionType((String) radioButton.getText());

                        //   spinner.setVisibility(View.INVISIBLE);


                    }
                    // on below line we are displaying a toast message.
                    Toast.makeText(SectionNew.this, "Selected Radio Button is : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            });


        viewModelSection = new ViewModelProvider(this).get(ViewModelSection.class);
        viewModelSection.init();
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "sd"+demndId, Toast.LENGTH_SHORT).show();
                res= viewModelSection.createSection(context,binding,section,binding.progressBar);
                Toast.makeText(context, ""+res, Toast.LENGTH_SHORT).show();
                SectionNew.this.finish();
            }
        }) ;



    }
    Section section=new Section();
//
    long parentId;
//
    public void getTechar(){
        Toast.makeText(context, "hjkhj", Toast.LENGTH_SHORT).show();

        viewModelTechar = new ViewModelProvider(this).get(ViewModelTechar.class);
        viewModelTechar.init();
        viewModelTechar.getTeaher(this.getApplicationContext(), binding.progressBar,1);
        viewModelTechar.mutableLiveData.observe(this, new Observer<List<Techars>>() {
            @Override
            public void onChanged(List<Techars> list) {
                Toast.makeText(context, "jkjk", Toast.LENGTH_SHORT).show();
                techarAdapter = new SpinrTecharAdapter(SectionNew.this, android.R.layout.simple_spinner_item, list);
                binding.spinerTechar.setAdapter(techarAdapter);
            }
        });


        // You can create an anonymous listener to handle the event when is selected an spinner item
        binding.spinerTechar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                Techars user = techarAdapter.getItem(position);
                section.setTeacherId(user.getTecharId());
                // Here you can do the action you want to...
//                Toast.makeText(SubjectNew.this, "ID: " + user.getSemesterNewId()
//                                + "\nName: " + user.getSemesterName(),
//                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {
            }
        });
    }
//
}