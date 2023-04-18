package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositoryFileStudent {

    private static RepositoryFileStudent Instance;
    //    private ArrayList<User> dataSet =new ArrayList<User>();
    public static RepositoryFileStudent getInstance(){
        if(Instance == null){
            Instance = new RepositoryFileStudent();
        }
        return Instance;
    }

    public Call<FileStudent> createFile(@Body FileStudent fileStudent){

        Call<FileStudent> call = Handler.getInstance().getApi().createPost(fileStudent);
        return  call;
    }
    public Call<FileStudent> createFileLader(@Body FileStudent fileStudent){

        Call<FileStudent> call = Handler.getInstance().getApi().createPostLader(fileStudent);
        return  call;
    }

    public Call<List<FileStudent>> getFileStudenttData(){
       Call<List<FileStudent>> call = Handler.getInstance().getApi().getFileStudentAll();
        return  call;}

    public Call<List<FileStudent>> getFileStudenttDataSem(long seId){
        Call<List<FileStudent>> call = Handler.getInstance().getApi().getFileStudentAll(seId);
        return  call;}

    public Call<List<FileStudent>> getFileStudentByLader(long seId){
        Call<List<FileStudent>> call = Handler.getInstance().getApi().getFileByLader(seId);
        return  call;}
    public Call<List<FileStudent>> getFileStudenta(long seId,int pid){
        Call<List<FileStudent>> call = Handler.getInstance().getApi().getFileStudentNew(seId,pid);
        return  call;}
}