package com.student.academicadvisingsyst.AdminOP.Models;

public class Subjects {
    private long SubjectId ;

    private String SubjectNameAr ;

    private String SubjectNameEn ;

    private String SubjectCode ;
    private int CountTime ;
    private int SubjectDemand ;
    private String SubjectType ;
    private long SubjectParentId ;
    private int AccreditedUnits ;
    private int Lecture ;
    private int Practical ;
    private int Exercises ;
    private int WeeklyContactHours ;
    private int SemesterId;
    private String SemesterName;

    private String ParentName;

    public String getParentName() {
        return ParentName;
    }

    public void setParentName(String parentName) {
        ParentName = parentName;
    }

    public String getSemesterName() {
        return SemesterName;
    }

    public void setSemesterName(String semesterName) {
        SemesterName = semesterName;
    }

    public Subjects(long subjectId, String subjectNameAr, String subjectNameEn, String subjectCode) {
        SubjectId = subjectId;
        SubjectNameAr = subjectNameAr;
        SubjectNameEn = subjectNameEn;
        SubjectCode = subjectCode;
    }

    public Subjects(long subjectId, String subjectNameAr, String subjectNameEn, String subjectCode,
                    int countTime, int subjectDemand, String subjectType, long subjectParentId) {
        SubjectId = subjectId;
        SubjectNameAr = subjectNameAr;
        SubjectNameEn = subjectNameEn;
        SubjectCode = subjectCode;
        CountTime = countTime;
        SubjectDemand = subjectDemand;
        SubjectType = subjectType;
        SubjectParentId = subjectParentId;
    }

    public Subjects() {
    }

    public Subjects(long subjectId, String subjectNameAr, String subjectNameEn,
                    String subjectCode, int countTime, int subjectDemand, String subjectType,
                    long subjectParentId, int accreditedUnits,
                    int lecture, int practical, int exercises,
                    int weeklyContactHours, int semesterId) {
        SubjectId = subjectId;
        SubjectNameAr = subjectNameAr;
        SubjectNameEn = subjectNameEn;
        SubjectCode = subjectCode;
        CountTime = countTime;
        SubjectDemand = subjectDemand;
        SubjectType = subjectType;
        SubjectParentId = subjectParentId;
        AccreditedUnits = accreditedUnits;
        Lecture = lecture;
        Practical = practical;
        Exercises = exercises;
        WeeklyContactHours = weeklyContactHours;
        SemesterId = semesterId;
    }

    public int getAccreditedUnits() {
        return AccreditedUnits;
    }

    public void setAccreditedUnits(int accreditedUnits) {
        AccreditedUnits = accreditedUnits;
    }

    public int getLecture() {
        return Lecture;
    }

    public void setLecture(int lecture) {
        Lecture = lecture;
    }

    public int getPractical() {
        return Practical;
    }

    public void setPractical(int practical) {
        Practical = practical;
    }

    public int getExercises() {
        return Exercises;
    }

    public void setExercises(int exercises) {
        Exercises = exercises;
    }

    public int getWeeklyContactHours() {
        return WeeklyContactHours;
    }

    public void setWeeklyContactHours(int weeklyContactHours) {
        WeeklyContactHours = weeklyContactHours;
    }

    public int getSemesterId() {
        return SemesterId;
    }

    public void setSemesterId(int semesterId) {
        SemesterId = semesterId;
    }

    public int getCountTime() {
        return CountTime;
    }

    public void setCountTime(int countTime) {
        CountTime = countTime;
    }

    public int getSubjectDemand() {
        return SubjectDemand;
    }

    public void setSubjectDemand(int subjectDemand) {
        SubjectDemand = subjectDemand;
    }

    public String getSubjectType() {
        return SubjectType;
    }

    public void setSubjectType(String subjectType) {
        SubjectType = subjectType;
    }

    public long getSubjectParentId() {
        return SubjectParentId;
    }

    public void setSubjectParentId(long subjectParentId) {
        SubjectParentId = subjectParentId;
    }

    public long getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(long subjectId) {
        SubjectId = subjectId;
    }

    public String getSubjectNameAr() {
        return SubjectNameAr;
    }

    public void setSubjectNameAr(String subjectNameAr) {
        SubjectNameAr = subjectNameAr;
    }

    public String getSubjectNameEn() {
        return SubjectNameEn;
    }

    public void setSubjectNameEn(String subjectNameEn) {
        SubjectNameEn = subjectNameEn;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        SubjectCode = subjectCode;
    }
}
