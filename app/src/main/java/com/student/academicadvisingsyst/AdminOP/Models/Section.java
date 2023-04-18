package com.student.academicadvisingsyst.AdminOP.Models;

public class Section {

    private long SectionId ;
    private String SectionName ;

    private long SubjectId ;
    private long TeacherId ;
    private String Status ;
    private String SectionType ;

    private int CountMin ;
    private int CountMax ;

    private  String YearId;
    String TecharName;
    String SubjectNameAr;
    String StatusRes;
    String StudentName;
    long FileStudentId;
    long SubSubjectId;
    private  long AttendanceId;

    private  long DailyScheduleId;
    private  String AttendanceDate;
    private  int AttendanceStutas;
    private  String AttendanceRes;
    private  String DayName;
    public String TimeOf ;
    public String TimeTo ;

    public String Result;

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getTimeOf() {
        return TimeOf;
    }

    public void setTimeOf(String timeOf) {
        TimeOf = timeOf;
    }

    public String getTimeTo() {
        return TimeTo;
    }

    public void setTimeTo(String timeTo) {
        TimeTo = timeTo;
    }

    public long getAttendanceId() {
        return AttendanceId;
    }

    public void setAttendanceId(long attendanceId) {
        AttendanceId = attendanceId;
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

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public long getFileStudentId() {
        return FileStudentId;
    }

    public void setFileStudentId(long fileStudentId) {
        FileStudentId = fileStudentId;
    }

    public long getSubSubjectId() {
        return SubSubjectId;
    }

    public void setSubSubjectId(long subSubjectId) {
        SubSubjectId = subSubjectId;
    }

    public String getStatusRes() {
        return StatusRes;
    }

    public void setStatusRes(String statusRes) {
        StatusRes = statusRes;
    }

    public String getTecharName() {
        return TecharName;
    }

    public void setTecharName(String techarName) {
        TecharName = techarName;
    }

    public String getSubjectNameAr() {
        return SubjectNameAr;
    }

    public void setSubjectNameAr(String subjectNameAr) {
        SubjectNameAr = subjectNameAr;
    }

    public Section(long sectionId, String sectionName,
                   long subjectId, long teacherId, String status,
                   String sectionType, int countMin, int countMax, String yearId) {
        SectionId = sectionId;
        SectionName = sectionName;
        SubjectId = subjectId;
        TeacherId = teacherId;
        Status = status;
        SectionType = sectionType;
        CountMin = countMin;
        CountMax = countMax;
        YearId=yearId;
    }

    public Section() {
    }

    public long getSectionId() {
        return SectionId;
    }

    public String getYearId() {
        return YearId;
    }

    public void setYearId(String yearId) {
        YearId = yearId;
    }

    public void setSectionId(long sectionId) {
        SectionId = sectionId;
    }

    public String getSectionName() {
        return SectionName;
    }

    public void setSectionName(String sectionName) {
        SectionName = sectionName;
    }

    public long getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(long subjectId) {
        SubjectId = subjectId;
    }

    public long getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(long teacherId) {
        TeacherId = teacherId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getSectionType() {
        return SectionType;
    }

    public void setSectionType(String sectionType) {
        SectionType = sectionType;
    }

    public int getCountMin() {
        return CountMin;
    }

    public void setCountMin(int countMin) {
        CountMin = countMin;
    }

    public int getCountMax() {
        return CountMax;
    }

    public void setCountMax(int countMax) {
        CountMax = countMax;
    }
}
