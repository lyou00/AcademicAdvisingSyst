package com.student.academicadvisingsyst.TecahrOp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.View.DailyScheduleNew;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelAttendance;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelDailySchedule;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.databinding.ActivityAttendanceNewBinding;
import com.student.academicadvisingsyst.databinding.ActivityDailyScheduleBinding;

public class AttendanceNew extends AppCompatActivity {

    ActivityAttendanceNewBinding binding;
    ViewModelAttendance viewModel;
    Context context;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAttendanceNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        context=this;
        intent=getIntent();
        //intent.putExtra("SectionId",mylists.get(position).getSectionId());
//        intent.putExtra("SectionName",mylists.get(position).getSectionName());
//        intent.putExtra("SubjectName",mylists.get(position).getSubjectNameAr());
//        intent.putExtra("TecharName",mylists.get(position).getSectionId());
        setContentView(binding.getRoot());
        binding.dayName.setText(intent.getStringExtra("DayName"));
        binding.txtDailyId.setText(intent.getLongExtra("DailyScheduleId",0)+"");
        binding.txtTimeOf.setText(intent.getStringExtra("TimeOf"));
        binding.txtTimeTo.setText(intent.getStringExtra("TimeTo"));

        Intent intent=new Intent(getApplicationContext(),AttendanceNew.class);


        String[] instruction = new String[] {"السبت", "الاحد", "الاثنين","الثلاثاء","الاربعاء","الخميس"};
 final Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog StartTime = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                binding.eddate.setText(""+ newDate.getTime());
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        binding.butDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime.show();

                // FileStudentNew.this.finish();
            }
        }) ;

        viewModel = new ViewModelProvider(this).get(ViewModelAttendance.class);
        viewModel.init();
        binding.btnNextFragmentSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 viewModel.createAttendancet(context,binding);
                AttendanceNew.this.finish();
            }
        }) ;

    }

}
