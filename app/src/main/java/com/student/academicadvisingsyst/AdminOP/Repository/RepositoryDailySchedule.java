package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.DailySchedule;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositoryDailySchedule {

    private static RepositoryDailySchedule Instance;
    //    private ArrayList<User> dataSet =new ArrayList<User>();
    public static RepositoryDailySchedule getInstance(){
        if(Instance == null){
            Instance = new RepositoryDailySchedule();
        }
        return Instance;
    }

    public Call<DailySchedule> createDailySchedule(@Body DailySchedule schedule){

        Call<DailySchedule> call = Handler.getInstance().getApi().creatDailySchedule(schedule);
        return  call;
    }

    public Call<List<DailySchedule>> getDailyScheduleData(){
       Call<List<DailySchedule>> call = Handler.getInstance().getApi().getAllDailyScheduleByDate(1);
return call;
    }

    public Call<List<DailySchedule>> getDailyScheduleDataBySection(long sectionId){
        Call<List<DailySchedule>> call = Handler.getInstance().getApi().getAllDailyScheduleByDate(sectionId);
        return call;
    }

    public Call<List<Section>> getStudentByYear(String yearId){
        Call<List<Section>> call = Handler.getInstance().getApi().getAllSectionByDate(yearId);
        return call;
    }

}
