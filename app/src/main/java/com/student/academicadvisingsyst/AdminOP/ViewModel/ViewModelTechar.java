package com.student.academicadvisingsyst.AdminOP.ViewModel;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryTechars;
import com.student.academicadvisingsyst.AdminOP.Models.Techars;
import com.student.academicadvisingsyst.databinding.ActivityTeachrNewBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelTechar extends ViewModel {

    public MutableLiveData<List<Techars>> mutableLiveData = new MutableLiveData<>();


    private RepositoryTechars repository;
    public void init(){

        if(mutableLiveData != null){
            return;
        }
        repository = RepositoryTechars.getInstance();

    }


    String res;
    private EditText edName,edAddress ,edNation,edUserName,edPhone,edPassword,edDateBr;

    public Techars initDataBind(ActivityTeachrNewBinding binding,String type,int ty){

        //edPhone = addStudentBinding.edPhone;
        String name = binding.edName.getText().toString();
        String address = binding.edAddress.getText().toString();
        String phone = binding.edPhone.getText().toString();
        String date = binding.edDateBr.getText().toString();


        Techars s= new Techars(
                1,name,address,phone
                ,date,ty,type);


        return s;
    }
    public  String create(Context context, ActivityTeachrNewBinding binding,String type,int ty) {
        Techars techars=new Techars();
        techars=initDataBind(binding,type,ty);


        RepositoryTechars.getInstance().createTeacher(techars).enqueue(new Callback<Techars>() {
            @Override
            public void onResponse(Call<Techars> call, Response<Techars> response) {


                // we are getting response from our body
                // and passing it to our modal class.
                Techars responseFromAPI = new Techars();
                responseFromAPI = response.body();
                Log.d(TAG, "onSuccess: " + response.body());

                res="onSuccess" ;
               // Toast.makeText(context, "i'm done " + response.body(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Techars> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res= "onFailure";
            }
        });
        return res;
    }
    public void getTeaher (Context context, ProgressBar bar,int id){
        RepositoryTechars.getInstance().getTeacherData(id).enqueue(new Callback<List<Techars>>() {
            @Override
            public void onResponse(Call<List<Techars>> call, Response<List<Techars>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }



                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Techars>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }}



