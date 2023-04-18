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

import com.student.academicadvisingsyst.AdminOP.Adapter.SpinrFileAdapter;
import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelFileStudent;
import com.student.academicadvisingsyst.databinding.LaderFileStudentNewBinding;

import java.util.List;

public class LaderFileStudentNew extends AppCompatActivity {
    private ProgressBar progressBar;

    String res;
    LaderFileStudentNewBinding binding;

    Context context;
    private ViewModelFileStudent viewModel;

    Spinner spinner;
    private long laderId;
    Intent intent;
    String laderName;

    SpinrFileAdapter spinrFileAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = LaderFileStudentNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent=getIntent();
        laderId=intent.getLongExtra("idlader",0);
        laderName=intent.getStringExtra("namelader");

        context=this;


        binding.txtLaderId.setText(laderId+"");
        binding.txtNameLader.setText(laderName);

        viewModel = new ViewModelProvider(this).get(ViewModelFileStudent.class);
        viewModel.init();


        final Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog  StartTime = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                binding.dateReg.setText(""+ newDate.getTime());
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        binding.btDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime.show();

            }
        }) ;
        viewModel = new ViewModelProvider(this).get(ViewModelFileStudent.class);
       viewModel.init();

       getFile(laderId);
        spinerAd();

        binding.butsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res= viewModel.createSFileStudentLader(context,binding);
                Toast.makeText(context, ""+res, Toast.LENGTH_SHORT).show();
                LaderFileStudentNew.this.finish();
            }
        });
    }

    public  void spinerAd(){
        // You can create an anonymous listener to handle the event when is selected an spinner item
        binding.spinerStudent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                // Here you get the current item (a User object) that is selected by its position
                FileStudent user = spinrFileAdapter.getItem(position);
                binding.studentId.setText(""+ user.getStudentId());
                binding.studentName.setText(""+ user.getStudentName());


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {
            }
        });
    }

    public  void getFile(long seid){



        viewModel.getFilwStudentBySemeNot(this.getApplicationContext(),binding.progressBar,seid,12);
        //viewModel.mutableLiveData
        //  setCategoryRecycleView();
        viewModel.mutableLiveData.observe(this, new Observer<List<FileStudent>>() {
            @Override
            public void onChanged(List<FileStudent> fileStudents) {
               // fileStudents.addAll(fileStudents);
                spinrFileAdapter = new SpinrFileAdapter(LaderFileStudentNew.this, android.R.layout.simple_spinner_item, fileStudents);
                binding.spinerStudent.setAdapter(spinrFileAdapter);

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

