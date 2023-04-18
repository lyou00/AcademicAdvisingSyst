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

import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryStudent;
import com.student.academicadvisingsyst.databinding.AddStudentBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelParnet extends ViewModel {
    public MutableLiveData<List<Student>> mutableLiveData = new MutableLiveData<>();


    private RepositoryStudent repository;
    public void init(){

        if(mutableLiveData != null){
            return;
        }
        repository = RepositoryStudent.getInstance();

    }


    String res;
    private EditText edName,edAddress ,edNation,edUserName,edPhone,edPassword,edDateBr;

    public Student initDataBind(AddStudentBinding addStudentBinding){
        edName = addStudentBinding.edName;
        edDateBr = addStudentBinding.edDateBr;
        edAddress = addStudentBinding.edAddress;
        edPhone = addStudentBinding.edPhone;
        edNation = addStudentBinding.edNation;
        edUserName = addStudentBinding.edUserName;
        edPassword = addStudentBinding.edPassword;
        //edPhone = addStudentBinding.edPhone;
        String name = edName.getText().toString();
        String address = edAddress.getText().toString();
        String phone = edPhone.getText().toString();
        String Id = edNation.getText().toString();
        String date = edDateBr.getText().toString();

        String password = edPassword.getText().toString();
        String username = edUserName.getText().toString();
        Student s= new Student(1,name,address,phone,
                "kjk",date,"jkj","kkk","klkk");
        return s;
    }
    public  String createStudent(Context context, AddStudentBinding addStudentBinding) {

        RepositoryStudent.getInstance().createStudent(initDataBind(addStudentBinding)).enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
               Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                // we are getting response from our body
                // and passing it to our modal class.
                Student responseFromAPI = new Student();
                responseFromAPI = response.body();
                Log.d(TAG, "onSuccess: " + response.body());

                res="onSuccess" +response.body();
              Toast.makeText(context, "i'm done " + response.headers(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res= "onFailure";
            }
        });
    return res;
    }
    public void getStudent (Context context, ProgressBar bar){
        RepositoryStudent.getInstance().getStudentData().enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                }
                mutableLiveData.setValue(response.body());

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
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


