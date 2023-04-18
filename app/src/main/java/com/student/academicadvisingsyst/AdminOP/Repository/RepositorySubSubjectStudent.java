package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.DailySchedule;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.Models.SubSubjectStudent;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositorySubSubjectStudent {

    private static RepositorySubSubjectStudent Instance;
    //    private ArrayList<User> dataSet =new ArrayList<User>();
    public static RepositorySubSubjectStudent getInstance(){
        if(Instance == null){
            Instance = new RepositorySubSubjectStudent();
        }
        return Instance;
    }

    public Call<SubSubjectStudent> createSubSubjectStudent(@Body SubSubjectStudent subjectStudent){

        Call<SubSubjectStudent> call = Handler.getInstance().getApi().creatSubSubjectStudent(subjectStudent);
        return  call;
    }

    public Call<List<SubSubjectStudent>> getDailyScheduleData(){
       Call<List<SubSubjectStudent>> call = Handler.getInstance().getApi().getAllSubSubjectStudent();
return call;
    }

    public Call<List<SubSubjectStudent>> getDailyScheduleDataBySection(long sectionId){
        Call<List<SubSubjectStudent>> call = Handler.getInstance().getApi().getAllSubSubjectStudentByDate(sectionId);
        return call;
    }
    public Call<List<SubSubjectStudent>> getDailyScheduleDataBySeFile(long fileStudentId){
        Call<List<SubSubjectStudent>> call = Handler.getInstance().getApi().getAllSubSubjectStudentByDate(fileStudentId);
        return call;
    }
    public Call<List<Section>> getStudentByYear(String yearId){
        Call<List<Section>> call = Handler.getInstance().getApi().getAllSectionByDate(yearId);
        return call;
    }

}
