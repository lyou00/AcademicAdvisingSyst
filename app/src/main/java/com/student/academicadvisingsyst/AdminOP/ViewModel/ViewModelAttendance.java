package com.student.academicadvisingsyst.AdminOP.ViewModel;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.student.academicadvisingsyst.AdminOP.Models.Attendance;
import com.student.academicadvisingsyst.AdminOP.Models.Courses;
import com.student.academicadvisingsyst.AdminOP.Models.DailySchedule;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryAttendance;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryCourses;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryDailySchedule;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryStudent;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.databinding.ActivityAttendanceNewBinding;
import com.student.academicadvisingsyst.databinding.ActivityDailyScheduleBinding;
import com.student.academicadvisingsyst.databinding.AddStudentBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelAttendance extends ViewModel {
    public MutableLiveData<List<Attendance>> mutableLiveData = new MutableLiveData<List<Attendance>>();


    private RepositoryAttendance repository;
    public void init(){

        if(mutableLiveData != null){
            return;
        }
        repository = RepositoryAttendance.getInstance();

    }


    String res;

    public Attendance initDataBind(ActivityAttendanceNewBinding binding){

        long DailyId=Long.parseLong(binding.txtDailyId.getText().toString());
        String date=binding.eddate.getText().toString();

        String dayname=binding.dayName.getText().toString();


        Attendance s= new Attendance(1,1,DailyId,date,1,"",dayname);
        return s;
    }
    public  String createAttendancet(Context context, ActivityAttendanceNewBinding binding) {

        RepositoryAttendance.getInstance().createAttendance(initDataBind(binding)).enqueue(new Callback<Attendance>() {
            @Override
            public void onResponse(Call<Attendance> call, Response<Attendance> response) {
                Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                // we are getting response from our body
                // and passing it to our modal class.
                Attendance responseFromAPI = new Attendance();
                responseFromAPI = response.body();
                Log.d(TAG, "onSuccess: " + response.body());

                res="onSuccess" +response.body();
                //Toast.makeText(context, "i'm done " + response.headers(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Attendance> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res= "onFailure";
            }
        });
        return res;
    }

    public  String createAttendancet(Context context,Attendance attendance) {

        RepositoryAttendance.getInstance().createAttendanceDetalis(attendance).enqueue(new Callback<Attendance>() {
            @Override
            public void onResponse(Call<Attendance> call, Response<Attendance> response) {
                Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                // we are getting response from our body
                // and passing it to our modal class.
                Attendance responseFromAPI = new Attendance();
                responseFromAPI = response.body();
                Log.d(TAG, "onSuccess: " + response.body());

                res="onSuccess" +response.body();
               // Toast.makeText(context, "i'm done " + response.headers(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Attendance> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res= "onFailure";
            }
        });
        return res;
    }
    public void getAttendanceByDailyId (Context context, ProgressBar bar,long id){
        RepositoryAttendance.getInstance().getAttendanceByDaily(id).enqueue(new Callback<List<Attendance>>() {
            @Override
            public void onResponse(Call<List<Attendance>> call, Response<List<Attendance>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Attendance>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }}



