package com.student.academicadvisingsyst.AdminOP.Models;

public class Attendance {
    private  long AttendanceId;

    private  long SubSubjectId;
    private  long DailyScheduleId;
    private  String AttendanceDate;
    private  int AttendanceStutas;
    private  String AttendanceRes;
    private  String DayName;


    public Attendance(long attendanceId, long subSubjectId,
                      long dailyScheduleId, String attendanceDate,
                      int attendanceStutas, String attendanceRes, String dayName) {
        AttendanceId = attendanceId;
        SubSubjectId = subSubjectId;
        DailyScheduleId = dailyScheduleId;
        AttendanceDate = attendanceDate;
        AttendanceStutas = attendanceStutas;
        AttendanceRes = attendanceRes;
        DayName = dayName;
    }

    public Attendance() {
    }

    public long getAttendanceId() {
        return AttendanceId;
    }

    public void setAttendanceId(long attendanceId) {
        AttendanceId = attendanceId;
    }

    public long getSubSubjectId() {
        return SubSubjectId;
    }

    public void setSubSubjectId(long subSubjectId) {
        SubSubjectId = subSubjectId;
    }

    public long getDailyScheduleId() {
        return DailyScheduleId;
    }

    public void setDailyScheduleId(long dailyScheduleId) {
        DailyScheduleId = dailyScheduleId;
    }

    public String getAttendanceDate() {
        return AttendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        AttendanceDate = attendanceDate;
    }

    public int getAttendanceStutas() {
        return AttendanceStutas;
    }

    public void setAttendanceStutas(int attendanceStutas) {
        AttendanceStutas = attendanceStutas;
    }

    public String getAttendanceRes() {
        return AttendanceRes;
    }

    public void setAttendanceRes(String attendanceRes) {
        AttendanceRes = attendanceRes;
    }

    public String getDayName() {
        return DayName;
    }

    public void setDayName(String dayName) {
        DayName = dayName;
    }
}
