package com.student.academicadvisingsyst.AdminOP.Repository;

import com.student.academicadvisingsyst.AdminOP.Models.Attendance;
import com.student.academicadvisingsyst.AdminOP.Models.DailySchedule;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.retrofit.Handler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

public class RepositoryAttendance {

    private static RepositoryAttendance Instance;
    //    private ArrayList<User> dataSet =new ArrayList<User>();
    public static RepositoryAttendance getInstance(){
        if(Instance == null){
            Instance = new RepositoryAttendance();
        }
        return Instance;
    }

    public Call<Attendance> createAttendance(@Body Attendance schedule){

        Call<Attendance> call = Handler.getInstance().getApi().creatAttendance(schedule);
        return  call;
    }

    public Call<Attendance> createAttendanceDetalis(@Body Attendance schedule){

        Call<Attendance> call = Handler.getInstance().getApi().creatAttendanceSetails(schedule);
        return  call;
    }

    public Call<List<Attendance>> getAttendanceByDaily(long id){
       Call<List<Attendance>> call = Handler.getInstance().getApi().getAllAttendance(id);
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
