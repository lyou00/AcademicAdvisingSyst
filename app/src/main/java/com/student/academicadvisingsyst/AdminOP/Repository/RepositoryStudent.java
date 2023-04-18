package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositoryStudent {

    private static RepositoryStudent Instance;
    //    private ArrayList<User> dataSet =new ArrayList<User>();
    public static RepositoryStudent getInstance(){
        if(Instance == null){
            Instance = new RepositoryStudent();
        }
        return Instance;
    }

    public Call<Student> createStudent(@Body Student student){

        Call<Student> call = Handler.getInstance().getApi().creatStudent(student);
        return  call;
    }
//    public Call<Student> signUser( Student user){
//
//        Call<Student> call = Handler.getInstance().getApi().SignInUser(user);
//        return  call;
//    }
    public Call<List<Student>> getStudentData(){
       Call<List<Student>> call = Handler.getInstance().getApi().getStudentAll();
        return  call;
//        Call<Student> calltargetResponse = Handler.getInstance().getApi().getUserData("Bearer "+token);
//        return  calltargetResponse;
    }
//    public Call<List<Product>> getProduct(){
//
//        Call<List<Product>> call = Handler.getInstance().getApi().getProduct();
//        return  call;
//    }
//    public Call<List<Category>> getCategories(){
//        Call<List<Category>> call = Handler.getInstance().getApi().getCategories();
//        return call;
//    }
//    public Call<List<Product>> getProductsByCategory(){
//        Call<List<Product>> call = Handler.getInstance().getApi().getProductsByCategory();
//        return call;
//    }
}
