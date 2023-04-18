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
import com.student.academicadvisingsyst.AdminOP.Repository.RepositorySection;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryStudent;
import com.student.academicadvisingsyst.databinding.SectionNewBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelSection extends ViewModel {
    public MutableLiveData<List<Section>> mutableLiveData = new MutableLiveData<>();


    private RepositoryStudent repository;
    public void init(){

        if(mutableLiveData != null){
            return;
        }
        repository = RepositoryStudent.getInstance();

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
    public  String createSection(Context context, SectionNewBinding binding,Section section,ProgressBar progressBar) {

        Section s=initDataBind(binding);
        s.setSubjectId(section.getSubjectId());
        s.setTeacherId(section.getTeacherId());
        s.setSectionType(section.getSectionType());

        RepositorySection.getInstance().createFile(s).enqueue(new Callback<Section>() {
            @Override
            public void onResponse(Call<Section> call, Response<Section> response) {
               Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                // we are getting response from our body
                // and passing it to our modal class.
                Section responseFromAPI = new Section();
                responseFromAPI = response.body();
                Log.d(TAG, "onSuccess: " + response.body());

                res="onSuccess" +response.body();
             // Toast.makeText(context, "i'm done " + response.body(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Section> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res= "onFailure";
            }
        });
    return res;
    }
    public void getSection (Context context, ProgressBar bar){
        RepositorySection.getInstance().getSectionIdData().enqueue(new Callback<List<Section>>() {
            @Override
            public void onResponse(Call<List<Section>> call, Response<List<Section>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Section>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });

    }

    public void getSectionTechar (Context context, ProgressBar bar,long techarId){
        RepositorySection.getInstance().getSectionTechar(techarId).enqueue(new Callback<List<Section>>() {
            @Override
            public void onResponse(Call<List<Section>> call, Response<List<Section>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());
                    Log.d(TAG, "onResponse: " + response.body());


                }


            }

            @Override
            public void onFailure(Call<List<Section>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });

    }
    public void getSectionBySubjectId (Context context, ProgressBar bar,long SubjectId){
        RepositorySection.getInstance().getSectionIdDataByIDSubject(SubjectId).enqueue(new Callback<List<Section>>() {
            @Override
            public void onResponse(Call<List<Section>> call, Response<List<Section>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Section>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }

    public void getSectionByAttend (Context context, ProgressBar bar,long SubjectId){
        RepositorySection.getInstance().getSectionIdDataByAttend(SubjectId).enqueue(new Callback<List<Section>>() {
            @Override
            public void onResponse(Call<List<Section>> call, Response<List<Section>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Section>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }

    public void getSubjectByFileId (Context context, ProgressBar bar,long fileId){
        RepositorySection.getInstance().getSectionByFileId(fileId).enqueue(new Callback<List<Section>>() {
            @Override
            public void onResponse(Call<List<Section>> call, Response<List<Section>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Section>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }

    public void getSectionTable (Context context, ProgressBar bar,long fileId){
        RepositorySection.getInstance().getSectionTable(fileId).enqueue(new Callback<List<Section>>() {
            @Override
            public void onResponse(Call<List<Section>> call, Response<List<Section>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Section>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }
    public void getSectionBySubjectId (Context context, ProgressBar bar,long SubjectId,long fileId){
        RepositorySection.getInstance().getSectionIdDataByIDSubject(SubjectId,fileId).enqueue(new Callback<List<Section>>() {
            @Override
            public void onResponse(Call<List<Section>> call, Response<List<Section>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Section>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }
    public void getFileSection (Context context, ProgressBar bar,long sectioId){
        RepositorySection.getInstance().getFileBySectionByFileId(sectioId).enqueue(new Callback<List<Section>>() {
            @Override
            public void onResponse(Call<List<Section>> call, Response<List<Section>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                }
                mutableLiveData.setValue(response.body());

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Section>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }

}




