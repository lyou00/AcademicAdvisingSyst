package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.Models.User;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositoryUser {

    private static RepositoryUser Instance;
    //    private ArrayList<User> dataSet =new ArrayList<User>();
    public static RepositoryUser getInstance(){
        if(Instance == null){
            Instance = new RepositoryUser();
        }
        return Instance;
    }

    public Call<User> createUser(@Body User user){

        Call<User> call = Handler.getInstance().getApi().createUser(user);
        return  call;
    }
    public Call<User> signUser(String num, String pas){

        Call<User> call = Handler.getInstance().getApi().SignInUser(num,pas);
        return  call;
    }
    public Call<List<User>> getUser() {
        Call<List<User>> call = Handler.getInstance().getApi().getUser();
        return call;
    }
}