package com.student.academicadvisingsyst.AdminOP.ViewModel;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.student.academicadvisingsyst.AdminOP.Models.DailySchedule;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryDailySchedule;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.databinding.ActivityDailyScheduleBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelDailySchedule extends ViewModel {
    public MutableLiveData<List<DailySchedule>> mutableLiveData = new MutableLiveData<List<DailySchedule>>();

    ArrayAdapter<String> adapter_instruction;

    private RepositoryDailySchedule repository;
    public void init(){

        if(mutableLiveData != null){
            return;
        }
        repository = RepositoryDailySchedule.getInstance();

    }


    String res;
    String dayNae;

    @SuppressLint("StaticFieldLeak")
    public DailySchedule initDataBind(ActivityDailyScheduleBinding binding){

        //edPhone = binding.edPhone;
        long SectionId=Long.parseLong(binding.txtId.getText().toString());
        String txtTimeOf =binding.txtTimeOf.getText().toString();
        String txtTimeTo=binding.txtTimeOf.getText().toString();



        DailySchedule s= new DailySchedule(SectionId,txtTimeOf,txtTimeTo,
                          1,"السبت","f","ddsd","14421");
        return s;
    }

    public  String createDailySchedule(Context context, ActivityDailyScheduleBinding binding) {


//        Section s=initDataBind(binding);
//        s.setSubjectId(section.getSubjectId());
//        s.setTeacherId(section.getTeacherId());
//        s.setSectionType(section.getSectionType());
        String[] instruction = new String[] {"السبت", "الاحد", "الاثنين","الثلاثاء","الاربعاء","الخميس"};
        adapter_instruction = new ArrayAdapter<>(
                context,
                R.layout.txt_dropdown,
                instruction
        );

        // Dropdown adapter
        binding.dropdownMedType.setAdapter(adapter_instruction);

        binding.dropdownMedType.setOnItemClickListener((adapterView, view1, i, l) -> {
            dayNae= binding.dropdownMedType.getText()+"";
        });
        dayNae= binding.dropdownMedType.getText()+"";

        DailySchedule schedule=initDataBind(binding);
       schedule.setDayName(dayNae);
        RepositoryDailySchedule.getInstance().createDailySchedule(schedule).enqueue(new Callback<DailySchedule>() {
            @Override
            public void onResponse(Call<DailySchedule> call, Response<DailySchedule> response) {
               Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                // we are getting response from our body
                // and passing it to our modal class.
                DailySchedule responseFromAPI = new DailySchedule();
                responseFromAPI = response.body();
                Log.d(TAG, "onSuccess: " + response.body());

                res="onSuccess" +response.body();
            //  Toast.makeText(context, "i'm done " + response.headers(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DailySchedule> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res= "onFailure";
            }
        });
    return res;
    }
    public void getDailyScheldule (Context context, ProgressBar bar){
        RepositoryDailySchedule.getInstance().getDailyScheduleData().enqueue(new Callback<List<DailySchedule>>() {
            @Override
            public void onResponse(Call<List<DailySchedule>> call, Response<List<DailySchedule>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<DailySchedule>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }
    public void getDailySchelduleBySection(Context context, ProgressBar bar,long sectionId){
        RepositoryDailySchedule.getInstance().getDailyScheduleDataBySection(sectionId).enqueue(new Callback<List<DailySchedule>>() {
            @Override
            public void onResponse(Call<List<DailySchedule>> call, Response<List<DailySchedule>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }
                bar.setVisibility(View.GONE);

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<DailySchedule>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }
}




