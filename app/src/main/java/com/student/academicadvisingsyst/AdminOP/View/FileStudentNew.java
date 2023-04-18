package com.student.academicadvisingsyst.AdminOP.View;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.AdminOP.Adapter.SpinrFileAdapter;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelFileStudent;
import com.student.academicadvisingsyst.databinding.FragmentDashboardBinding;

import java.util.List;

public class FileStudentNew extends AppCompatActivity {
    private ProgressBar progressBar;

    String res;
    FragmentDashboardBinding binding;

    private Button btn_save,btDate ;
    Context context;
    private ViewModelFileStudent viewModel;

    SpinrFileAdapter spinrFileAdapter;
    private SearchView searchView;
    Spinner spinner;
    private long semeterId;
    Intent intent;
    TextView txtSemester,SetmeterName;
    String SemesterName;

    EditText date;
    TextView StudentId,StudentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent=getIntent();
        semeterId=intent.getLongExtra("semesterId",0);
        SemesterName=intent.getStringExtra("semesterName");

        context=this;

        txtSemester=binding.txtSemester;
        StudentId=binding.studentId;
        StudentName=binding.studentName;
        SetmeterName=binding.SetmeterName;
date=binding.dateReg;
        progressBar=binding.progressBar;
        txtSemester.setText(semeterId+"");
        SetmeterName.setText(SemesterName);
        btDate = binding.btDate;
        btn_save = binding.butsave;

        spinner=binding.spinerStudent;
        viewModel = new ViewModelProvider(this).get(ViewModelFileStudent.class);
        viewModel.init();


        final Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog  StartTime = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                date.setText(""+ newDate.getTime());
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        btDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                           DialogFragment newFragment = new DatePickerFragment();
//                newFragment.show(getSupportFragmentManager(), "datePicker");
//                newFragment.
//              //  res= viewModel.create(context,binding);
//                Toast.makeText(context, "jjjjj"+res.toString(), Toast.LENGTH_SHORT).show();
                StartTime.show();

                // FileStudentNew.this.finish();
            }
        }) ;
        viewModel = new ViewModelProvider(this).get(ViewModelFileStudent.class);
       viewModel.init();

       getFile(semeterId);
        spinerAd();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res= viewModel.createSFileStudent(context,binding);
                Toast.makeText(context, ""+res, Toast.LENGTH_SHORT).show();
                FileStudentNew.this.finish();
            }
        });
    }

    public  void spinerAd(){
        // You can create an anonymous listener to handle the event when is selected an spinner item
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                FileStudent user = spinrFileAdapter.getItem(position);
                StudentId.setText(""+ user.getStudentId());
                StudentName.setText(""+ user.getStudentName());

                //getFile(user.get());
                // Here you can do the action you want to...
              //  Toast.makeText(FileStudentNew.this, "ID: " + user.getSemesterNewId()
                //                + "\nName: " + user.getStudentName(),
                  //      Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {
            }
        });
    }

    public  void getFile(long seid){



        viewModel.getFilwStudentBySemeNot(this.getApplicationContext(),progressBar,seid,8);
        //viewModel.mutableLiveData
        //  setCategoryRecycleView();
        viewModel.mutableLiveData.observe(this, new Observer<List<FileStudent>>() {
            @Override
            public void onChanged(List<FileStudent> fileStudents) {
               // fileStudents.addAll(fileStudents);
                spinrFileAdapter = new SpinrFileAdapter(FileStudentNew.this, android.R.layout.simple_spinner_item, fileStudents);
                spinner.setAdapter(spinrFileAdapter);

//                for (int i = 0; i <fileStudents.size() ; i++) {
//                    Toast.makeText(context, "aa"+fileStudents.get(i).getStudentName(), Toast.LENGTH_SHORT).show();
//
//                }
                //Toast.makeText(context, "aa"+fileStudents.get(1).getFileStudentId(), Toast.LENGTH_SHORT).show();

                //adapter.updateList(fileStudents);
            }
        });



    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
            dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
            return  dialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
          //  txt.setText(ConverterDate.ConvertDate(year, month + 1, day));
        }
    }
}

