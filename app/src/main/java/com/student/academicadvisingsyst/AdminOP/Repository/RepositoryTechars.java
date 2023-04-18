package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.Techars;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositoryTechars {
    private static RepositoryTechars Instance;

    public static RepositoryTechars getInstance(){
        if(Instance == null){
            Instance = new RepositoryTechars();
        }
        return Instance;
    }

    public Call<Techars> createTeacher(@Body Techars teacher){

        Call<Techars> call = Handler.getInstance().getApi().creatTeacher(teacher);
        return  call;
    }
    //    public Call<Student> signUser( Student user){
//
//        Call<Student> call = Handler.getInstance().getApi().SignInUser(user);
//        return  call;
//    }
    public Call<List<Techars>> getTeacherData(int id){
        Call<List<Techars>> call = Handler.getInstance().getApi().getTeacherClass(id);
        return  call;
}
}
