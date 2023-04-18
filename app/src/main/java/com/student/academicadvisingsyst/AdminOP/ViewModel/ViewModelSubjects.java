package com.student.academicadvisingsyst.AdminOP.ViewModel;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.student.academicadvisingsyst.AdminOP.Models.Subjects;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryStudent;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositorySubjects;
import com.student.academicadvisingsyst.AdminOP.View.SubjectNew;
import com.student.academicadvisingsyst.databinding.SubjectNewBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelSubjects extends ViewModel {
    public MutableLiveData<ArrayList<Subjects>> mutableLiveData = new MutableLiveData<>();


    private RepositoryStudent repository;
    public void init(){

        if(mutableLiveData != null){
            return;
        }
        repository = RepositoryStudent.getInstance();

    }


    String res;
    private EditText subjectNameAr,subjectNameEn ,subjectNameCode,edCountTime,edSubjectDemand,edSubjectType,edDateBr;

    RadioGroup radioGroup;
    RadioButton rdSubDemand,rdSubDemandNot,rdSubOretical,rdSubOreticalAndPractical;
    int demandValue;
    String Type;
    long parentId=0;
    public Subjects initDataBind(SubjectNewBinding binding){
        subjectNameAr = binding.subjectNameAr;
        subjectNameEn = binding.subjectNameEn;
        subjectNameCode = binding.subjectNameCode;
        edCountTime = binding.edCountTime;
        rdSubDemand=binding.rdSubDemand;

        rdSubDemandNot=binding.rdSubDemandNot;
        rdSubOretical=binding.rdSubOretical;
        rdSubOreticalAndPractical=binding.rdSubOreticalAndPractical;


        if(rdSubOretical.isChecked()){
            Type="نظري";
        }else if(rdSubDemandNot.isChecked()){
            Type="نظري و عملي";
        }



        String namear = binding.subjectNameAr.getText().toString();
        String nameen = binding.subjectNameEn.getText().toString();
        String namecode = binding.subjectNameCode.getText().toString();
        int countTime= Integer.parseInt(edCountTime.getText().toString());



        Subjects s= new Subjects(1,namear,nameen,namecode,countTime,demandValue,Type,parentId);
        return s;
    }
    public  String createSubject(Context context, SubjectNewBinding binding,long parentId,int demend,ProgressBar bar) {

        Subjects subjects=initDataBind(binding);
        subjects.setSubjectParentId(parentId);
//        if (parentId!=0){
//            demend=2;
//        }else {
//            demend=1;
//
//        }
        subjects.setSubjectDemand(demend);
        //Toast.makeText(context, "ty"+Type, Toast.LENGTH_SHORT).show();

        RepositorySubjects.getInstance().createSubjects(subjects).enqueue(new Callback<Subjects>() {
            @Override
            public void onResponse(Call<Subjects> call, Response<Subjects> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                    // we are getting response from our body
                    // and passing it to our modal class.
                    bar.setVisibility(View.GONE);
                    Subjects responseFromAPI = new Subjects();
                    responseFromAPI = response.body();
                    Log.d(TAG, "onSuccess: " + response.body());

                    res="onSuccess" +response.body();
                   // Toast.makeText(context, "i'm done " + response.headers(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Subjects> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res= "onFailure";
            }
        });
    return res;
    }
    public void getSubject (Context context, ProgressBar bar){
        RepositorySubjects.getInstance().getSubjects().enqueue(new Callback<ArrayList<Subjects>>() {
            @Override
            public void onResponse(Call<ArrayList<Subjects>> call, Response<ArrayList<Subjects>> response) {
                if (response.isSuccessful()) {
               bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<Subjects>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }}



//    public  void signInUser(User user, Activity activity, Context context,View view){
//        Repository.getInstance().signUser(user).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                Log.d(TAG, "onResponse: done");
//                if (!response.isSuccessful()){
//                    Log.d(TAG, "onResponse: "+response.body().getAccess_token());
//                    Log.d(TAG, "onResponse: "+response.body().toString());
//                    Log.d(TAG, "onResponse: "+response.raw());
//                    Toast.makeText(context,response.body().getAccess_token(),Toast.LENGTH_LONG).show();
//                    getUserData(response.body().getAccess_token(),view);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                Toast.makeText(context,"",Toast.LENGTH_LONG).show();
//                //  getUserData(response.body().getAccess_token(),view);
//            }
//        });
//    }


