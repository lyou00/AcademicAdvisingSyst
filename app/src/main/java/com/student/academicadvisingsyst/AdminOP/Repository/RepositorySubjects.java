package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.Subjects;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositorySubjects {

    private static RepositorySubjects Instance;
    //    private ArrayList<User> dataSet =new ArrayList<User>();
    public static RepositorySubjects getInstance(){
        if(Instance == null){
            Instance = new RepositorySubjects();
        }
        return Instance;
    }

    public Call<Subjects> createSubjects(@Body Subjects subjects){

        Call<Subjects> call = Handler.getInstance().getApi().creatSubjects(subjects);
        return  call;
    }
//
//    }
    public Call<ArrayList<Subjects>> getSubjects(){
       Call<ArrayList<Subjects>> call = Handler.getInstance().getApi().getSubjectAll();
        return  call;
    }
    public Call<ArrayList<Subjects>> getSubjects(long id){
        Call<ArrayList<Subjects>> call = Handler.getInstance().getApi().getSubjectAll();
        return  call;
    }

    public Call<ArrayList<Subjects>> getSubjectsNew(){
        Call<ArrayList<Subjects>> call = Handler.getInstance().getApi().getSubjectAll();
        return  call;
    }

}
