package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.SemesterNew;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositorySemester {

    private static RepositorySemester Instance;
    //    private ArrayList<User> dataSet =new ArrayList<User>();
    public static RepositorySemester getInstance(){
        if(Instance == null){
            Instance = new RepositorySemester();
        }
        return Instance;
    }

    public Call<SemesterNew> createSemester(@Body SemesterNew semesterNew){

        Call<SemesterNew> call = Handler.getInstance().getApi().creatSemesterNew(semesterNew);
        return  call;
    }

    public Call<List<SemesterNew>> getStudentData(){
       Call<List<SemesterNew>> call = Handler.getInstance().getApi().getSemesterNewAll();
        return  call;

    }
}
