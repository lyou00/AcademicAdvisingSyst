package com.student.academicadvisingsyst.AdminOP.ViewModel;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.Models.SubSubjectStudent;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositorySection;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryStudent;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositorySubSubjectStudent;
import com.student.academicadvisingsyst.databinding.SectionNewBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelSubSubjectStudent extends ViewModel {
    public MutableLiveData<List<SubSubjectStudent>> mutableLiveData = new MutableLiveData<>();


    private RepositorySubSubjectStudent repository;
    public void init(){

        if(mutableLiveData != null){
            return;
        }
        repository = RepositorySubSubjectStudent.getInstance();

    }


    String res;
    @SuppressLint("StaticFieldLeak")
    private EditText edsectionName,edsectionCountMin ,edsectionCountMax;

    public Section initDataBind(SectionNewBinding binding){

        //edPhone = binding.edPhone;
        String sectionName =binding.sectionName.getText().toString();
        int sectionCountMin = Integer.parseInt(binding.sectionCountMin.getText().toString());
        int sectionCountMax = Integer.parseInt(binding.sectionCountMax.getText().toString());



        Section s= new Section(1,sectionName,0,0,"","",sectionCountMin,sectionCountMax,"");
        return s;
    }
    public  String createSection(Context context, SubSubjectStudent subjectStudent) {


        RepositorySubSubjectStudent.getInstance().createSubSubjectStudent(subjectStudent).enqueue(new Callback<SubSubjectStudent>() {
            @Override
            public void onResponse(Call<SubSubjectStudent> call, Response<SubSubjectStudent> response) {
               Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                // we are getting response from our body
                // and passing it to our modal class.
            SubSubjectStudent responseFromAPI = new SubSubjectStudent();
                responseFromAPI = response.body();
                Log.d(TAG, "onSuccess: " + response.body());

                res="onSuccess" +response.body();
             // Toast.makeText(context, "i'm done " + response.headers(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<SubSubjectStudent> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res= "onFailure";
            }
        });
    return res;
    }
    public void getSection (Context context, ProgressBar bar){
        RepositorySubSubjectStudent.getInstance().getDailyScheduleData().enqueue(new Callback<List<SubSubjectStudent>>() {
            @Override
            public void onResponse(Call<List<SubSubjectStudent>> call, Response<List<SubSubjectStudent>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<SubSubjectStudent>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });

    }
    public void getSectionBySubjectId (Context context, ProgressBar bar,long SubjectId){
        RepositorySubSubjectStudent.getInstance().getDailyScheduleDataBySection(SubjectId).enqueue(new Callback<List<SubSubjectStudent>>() {
            @Override
            public void onResponse(Call<List<SubSubjectStudent>> call, Response<List<SubSubjectStudent>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<SubSubjectStudent>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }
}




