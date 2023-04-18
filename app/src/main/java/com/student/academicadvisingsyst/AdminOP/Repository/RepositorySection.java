package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositorySection {

    private static RepositorySection Instance;
    //    private ArrayList<User> dataSet =new ArrayList<User>();
    public static RepositorySection getInstance(){
        if(Instance == null){
            Instance = new RepositorySection();
        }
        return Instance;
    }

    public Call<Section> createFile(@Body Section section){

        Call<Section> call = Handler.getInstance().getApi().creatSection(section);
        return  call;
    }

    public Call<List<Section>> getSectionIdData(){
       Call<List<Section>> call = Handler.getInstance().getApi().getAllSection();
        return call;
    }
    public Call<List<Section>> getSectionTechar(long techarId){
        Call<List<Section>> call = Handler.getInstance().getApi().getSectionTeachr(techarId);
        return call;
    }

    public Call<List<Section>> getSectionIdDataByIDSubject(long id){
        Call<List<Section>> call = Handler.getInstance().getApi().getAllSectionBySeubjectId(id);
        return call;
    }
    public Call<List<Section>> getSectionIdDataByAttend(long id){
        Call<List<Section>> call = Handler.getInstance().getApi().getAllSectionBAttend(id);
        return call;
    }


    public Call<List<Section>> getSectionByFileId(long id){
        Call<List<Section>> call = Handler.getInstance().getApi().getSubjectByIdFile(id);
        return call;
    }

    public Call<List<Section>> getSectionTable(long id){
        Call<List<Section>> call = Handler.getInstance().getApi().getSectionTable(id);
        return call;
    }
    public Call<List<Section>> getFileBySectionByFileId(long id){
        Call<List<Section>> call = Handler.getInstance().getApi().getFileBySection(id);
        return call;
    }
    public Call<List<Section>> getSectionIdDataByIDSubject(long id,long fileid){
        Call<List<Section>> call = Handler.getInstance().getApi().getAllSectionBySeubjectId(id,fileid);
        return call;
    }
    public Call<List<Section>> getStudentByYear(String yearId){
        Call<List<Section>> call = Handler.getInstance().getApi().getAllSectionByDate(yearId);
        return call;
    }

}
