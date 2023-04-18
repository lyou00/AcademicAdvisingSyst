package com.student.academicadvisingsyst.AdminOP.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelDailySchedule;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.databinding.ActivityDailyScheduleBinding;

public class DailyScheduleNew extends AppCompatActivity {

    Button btnNextFragment_submit;
    ActivityDailyScheduleBinding binding;
    private ViewModelDailySchedule viewModel;

    String res;

    Context context;
    Intent intent;
    ArrayAdapter<String> adapter_instruction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDailyScheduleBinding.inflate(getLayoutInflater());

        context=this;
        intent=getIntent();
        //intent.putExtra("SectionId",mylists.get(position).getSectionId());
//        intent.putExtra("SectionName",mylists.get(position).getSectionName());
//        intent.putExtra("SubjectName",mylists.get(position).getSubjectNameAr());
//        intent.putExtra("TecharName",mylists.get(position).getSectionId());
        setContentView(binding.getRoot());
        binding.txtId.setText(intent.getStringExtra("SectionId"));
        binding.txtNameSection.setText(intent.getStringExtra("SectionName"));
        binding.txtNameTechar.setText(intent.getStringExtra("TecharName"));
        binding.txtNameSubject.setText(intent.getStringExtra("SubjectName"));
        String[] instruction = new String[] {"السبت", "الاحد", "الاثنين","الثلاثاء","الاربعاء","الخميس"};
        adapter_instruction = new ArrayAdapter<>(
                getApplicationContext(),
                R.layout.txt_dropdown,
                instruction
        );

        // Dropdown adapter
        binding.dropdownMedType.setAdapter(adapter_instruction);

        binding.dropdownMedType.setOnItemClickListener((adapterView, view1, i, l) -> {
            binding.txtNameSubject.setText( binding.dropdownMedType.getListSelection()+"");
        });
        binding.btTimeOf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(DailyScheduleNew.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        binding.txtTimeOf.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
        binding.btTimeTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(DailyScheduleNew.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        binding.txtTimeTo.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        viewModel = new ViewModelProvider(this).get(ViewModelDailySchedule.class);
        viewModel.init();
        binding.btnNextFragmentSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "sd", Toast.LENGTH_SHORT).show();
                res= viewModel.createDailySchedule(context,binding);
                Toast.makeText(context, ""+res, Toast.LENGTH_SHORT).show();
                DailyScheduleNew.this.finish();
            }
        }) ;

    }
}