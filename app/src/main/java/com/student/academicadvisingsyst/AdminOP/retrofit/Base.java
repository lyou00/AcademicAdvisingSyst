package com.student.academicadvisingsyst.AdminOP.retrofit;

import com.student.academicadvisingsyst.AdminOP.Models.Attendance;
import com.student.academicadvisingsyst.AdminOP.Models.Courses;
import com.student.academicadvisingsyst.AdminOP.Models.DailySchedule;
import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.AdminOP.Models.Section;
import com.student.academicadvisingsyst.AdminOP.Models.SemesterNew;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.Models.SubSubjectStudent;
import com.student.academicadvisingsyst.AdminOP.Models.Subjects;
import com.student.academicadvisingsyst.AdminOP.Models.Techars;
import com.student.academicadvisingsyst.AdminOP.Models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Base {
  String BASE_URL ="http://192.168.137.1/AcademicAdvisingSystemWebAPINN/";
//String BASE_URL ="http://studentapp101-001-site1.itempurl.com/";

    @POST("api/User")
    Call<User> createUser(@Body User user);
    @GET("api/User/login")
//    @FormUrlEncoded
    Call<User> SignInUser(@Query("un") String un, @Query("ps")String Password);
    @GET("api/User")
    Call<List<User>> getUser( );

    //Opretion Student
    //get
    @GET("api/Student")
    Call<List<Student>> getStudentAll();

    //get one Student
    @GET("Student/{id}")
    Call<Student> getStudentClass(@Path("id") int id);

    //insert
    @POST("api/Student")
    Call<Student> creatStudent(@Body Student studentClass);

    //update
    @PUT("update/{id}")
    Call<Student> updatePost(@Path("id") int id, @Body Student studentClass);

    //delete
    @DELETE("delete/{id}")
    Call<Student> deletePost(@Path("id") int id);
   // getCoursesAll
    // Api Teacher
    @GET("api/Techars")
    Call<List<Techars>> getTeacherAll();

    //get one Student
    @GET("api/Techars/typeget/{id}")
    Call<List<Techars>> getTeacherClass(@Path("id") int id);

    //insert
    @POST("api/Techars")
    Call<Techars> creatTeacher(@Body Techars teacher);

    //update
    @PUT("update/{id}")
    Call<Techars> updateTeacher(@Path("id") int id, @Body Techars teacher);

    //delete
    @DELETE("delete/{id}")
    Call<Techars> deleteTeacher(@Path("id") int id);

    ///



    // Api Courses
    @GET("api/Courses")
    Call<List<Courses>> getCoursesAll();

    //get one Student
    @GET("Courses/{id}")
    Call<Courses> getCoursesClass(@Path("id") int id);

    //insert
    @POST("api/Courses")
    Call<Courses> creatCourses(@Body Courses courses);

    //update
    @PUT("update/{id}")
    Call<Courses> updateCourses(@Path("id") int id, @Body Courses courses);

    //delete
    @DELETE("delete/{id}")
    Call<Techars> deleteCourses(@Path("id") int id);



    ///

    // Api Semester
    @GET("api/Semester")
    Call<List<SemesterNew>> getSemesterNewAll();

    //get one SemesterNew
    @GET("Semester/{id}")
    Call<SemesterNew> getCSemesterNew(@Path("id") int id);

    //insert
    @POST("api/Semester")
    Call<SemesterNew> creatSemesterNew(@Body SemesterNew semesterNew);

    //update
    @PUT("Semester/{id}")
    Call<SemesterNew> updateSemesterNew(@Path("id") int id, @Body SemesterNew courses);

    //delete
    @DELETE("delete/{id}")
    Call<Techars> deleteSemesterNew(@Path("id") int id);



    ///


    //Opretion FileStudent
    //get
    @GET("api/FileStudent")
    Call<List<FileStudent>> getFileStudentAll();
    @GET("api/FileStudent/{id}")
    Call<List<FileStudent>> getFileStudentAll(@Path("id") long id);
    @GET("api/FileStudent/studentget/{id}/{pid}")
    Call<List<FileStudent>> getFileStudentNew(@Path("id") long id,@Path("pid") long pid);
    //get one FileStudent

    //insert
    @POST("api/FileStudent")
    Call<FileStudent> createPost(@Body FileStudent fileStudentclass);
    @POST("api/FileStudent/PostLader")
    Call<FileStudent> createPostLader(@Body FileStudent fileStudentclass);

    @GET("api/FileStudent/getFileLeadr/{id}")
    Call<List<FileStudent>> getFileByLader(@Path("id") long id);
    //update
    @PUT("update/{id}")
    Call<FileStudent> updatePost(@Path("id") int id, @Body FileStudent fileStudentclass);
    @DELETE("delete/{id}")
    Call<FileStudent> deleteFileStudent(@Path("id") int id);
    //delete


    //Opretion Subject
    //get
    @GET("api/Subject")
    Call<ArrayList<Subjects>> getSubjectAll();

    //get one Subject

    //insert
    @POST("api/Subject")
    Call<Subjects> creatSubjects(@Body Subjects subject);

    //update
    @PUT("update/{id}")
    Call<Subjects> updateSubject(@Path("id") int id, @Body Subjects subject);
    @DELETE("delete/{id}")
    Call<Subjects> deleteSubject(@Path("id") int id);




    //Opretion Section
    //get

    @GET("api/Section/getsectiontable/{id}")
    Call<List<Section>> getSectionTable(@Path("id") long id);
    @GET("api/FileStudent/getsubjectbyid/{id}")
    Call<List<Section>> getSubjectByIdFile(@Path("id") long id);
    @GET("api/Section/GetFileStudentBySection/{sectionId}")
    Call<List<Section>> getFileBySection(@Path("sectionId") long id);

    @GET("api/Section")
    Call<List<Section>> getAllSection();
    @GET("api/Section")
    Call<List<Section>> getAllSectionByDate(@Path("id") String id);

 @GET("api/Section/getsubject/{id}")

 Call<List<Section>> getAllSectionBySeubjectId(@Path("id") long id);

    @GET("api/Section/GetAttend/{id}")

    Call<List<Section>> getAllSectionBAttend(@Path("id") long id);

    @GET("api/Section/getsectiontechar/{id}")

    Call<List<Section>> getSectionTeachr(@Path("id") long id);
    //get one Section
    @GET("api/Section/getsubjectfile/{id}/{fileId}")

    Call<List<Section>> getAllSectionBySeubjectId(@Path("id") long id,@Path("fileId") long fileId);


    //insert
    @POST("api/Section")
    Call<Section> creatSection(@Body Section section);

    //update
    @PUT("api/Section/{id}")
    Call<Section> updateSection(@Path("id") int id, @Body Section section);
    @DELETE("api/Section/{id}")
    Call<Section> deleteSection(@Path("id") int id);



    //AttendceOp

    @GET("api/Attendance/GetAttendec/{id}")

    Call<List<Attendance>> getAllAttendance(@Path("id") long i);


    //insert
    @POST("api/Attendance")
    Call<Attendance> creatAttendance(@Body Attendance section);

    @POST("api/AttendanceDetails")
    Call<Attendance> creatAttendanceSetails(@Body Attendance section);

    //update
    @PUT("api/Attendance/{id}")
    Call<Attendance> updateAttendance(@Path("id") int id, @Body Attendance section);
    @DELETE("api/Attendance/{id}")
    Call<Attendance> deleteAttendance(@Path("id") int id);


    //Opretion DailySchedule
    //get
    @GET("api/DailySchedule")
    Call<List<DailySchedule>> getAllDailySchedule();
    @GET("api/DailySchedule/GetDetails/{id}")
    Call<List<DailySchedule>> getAllDailyScheduleByDate(@Path("id") long id);
    //get one DailySchedule

    //insert
    @POST("api/DailySchedule")
    Call<DailySchedule> creatDailySchedule(@Body DailySchedule schedule);

    //update
    @PUT("api/DailySchedule/{id}")
    Call<DailySchedule> updateDailySchedule(@Path("id") int id, @Body DailySchedule schedule);
    @DELETE("api/DailySchedule/{id}")
    Call<DailySchedule> deleteDailySchedule(@Path("id") int id);


    //Opretion SubSubjectStudent
    //get
    @GET("api/SubSubjectStudent")
    Call<List<SubSubjectStudent>> getAllSubSubjectStudent();
    @GET("api/SubSubjectStudent/GetDetails/{id}")
    Call<List<SubSubjectStudent>> getAllSubSubjectStudentByDate(@Path("id") long id);
    //get one SubSubjectStudent

    //insert
    @POST("api/SubSubjectStudent")
    Call<SubSubjectStudent> creatSubSubjectStudent(@Body SubSubjectStudent subjectStudent);

    //update
    @PUT("api/SubSubjectStudent/{id}")
    Call<SubSubjectStudent> updateSubSubjectStudent(@Path("id") int id, @Body SubSubjectStudent subjectStudent);
    @DELETE("api/SubSubjectStudent/{id}")
    Call<SubSubjectStudent> deleteSubSubjectStudente(@Path("id") int id);

}
