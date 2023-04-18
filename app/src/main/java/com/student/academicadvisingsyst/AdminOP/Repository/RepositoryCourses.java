package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.Courses;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositoryCourses {

    private static RepositoryCourses Instance;
    //    private ArrayList<User> dataSet =new ArrayList<User>();
    public static RepositoryCourses getInstance(){
        if(Instance == null){
            Instance = new RepositoryCourses();
        }
        return Instance;
    }

    public Call<Courses> createFile(@Body Courses courses){

        Call<Courses> call = Handler.getInstance().getApi().creatCourses(courses);
        return  call;
    }

    public Call<List<Courses>> getCourses(){
       Call<List<Courses>> call = Handler.getInstance().getApi().getCoursesAll();
        return  call;

    }

}
