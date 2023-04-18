package com.student.academicadvisingsyst.AdminOP.View;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.student.academicadvisingsyst.AdminOP.Adapter.SpinAdapter;
import com.student.academicadvisingsyst.AdminOP.Adapter.SubjectAdapter;
import com.student.academicadvisingsyst.AdminOP.Models.SemesterNew;
import com.student.academicadvisingsyst.AdminOP.Models.Subjects;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSemester;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSubjects;
import com.student.academicadvisingsyst.databinding.SubjectNewBinding;

import java.util.List;

public class SubjectNew extends AppCompatActivity {

    String res;
    SubjectNewBinding binding;

    SubjectAdapter subjectAdapter;
    private Button btn_save ;
    Context context;
    private ViewModelSubjects viewModel;


    int demndId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = SubjectNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context=this;


        // on below line we are adding check change listener for our radio group.
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // on below line we are getting radio button from our group.
                RadioButton radioButton = findViewById(checkedId);

                if (radioButton.getText().equals("متطلب")) {
                    demndId = 1;
                    getSubjectId();;
                //    spinner.setVisibility(View.VISIBLE);
                } else if (radioButton.getText().equals("غير متطلب"))
                    {
                        demndId = 2;
                        parentId=0;
                     //   spinner.setVisibility(View.INVISIBLE);


                    }
                    // on below line we are displaying a toast message.
                    Toast.makeText(SubjectNew.this, "Selected Radio Button is : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            });


        viewModel = new ViewModelProvider(this).get(ViewModelSubjects.class);
        viewModel.init();
         binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "sd"+demndId, Toast.LENGTH_SHORT).show();
                res= viewModel.createSubject(context,binding,parentId,demndId,binding.progressBar);
             //   Toast.makeText(context, ""+res, Toast.LENGTH_SHORT).show();
                SubjectNew.this.finish();
            }
        }) ;



    }

    long parentId;

    public void getSubjectId(){
        Toast.makeText(context, "hjkhj", Toast.LENGTH_SHORT).show();

        viewModel = new ViewModelProvider(this).get(ViewModelSubjects.class);
        viewModel.getSubject(this.getApplicationContext(), binding.progressBar);
        viewModel.mutableLiveData.observe(this, new Observer<List<Subjects>>() {
            @Override
            public void onChanged(List<Subjects> list) {
                Toast.makeText(context, "jkjk", Toast.LENGTH_SHORT).show();
                subjectAdapter = new SubjectAdapter(SubjectNew.this, android.R.layout.simple_spinner_item, list);
                binding.spinerSubject.setAdapter(subjectAdapter);
            }
        });


        // You can create an anonymous listener to handle the event when is selected an spinner item
        binding.spinerSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                Subjects user = subjectAdapter.getItem(position);
                parentId=user.getSubjectId();
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
}