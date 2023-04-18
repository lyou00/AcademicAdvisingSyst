package com.student.academicadvisingsyst.AdminOP.Models;

public class SubSubjectStudent {

    private  long SubSubjectId;
    private  long DailyScheduleId;
    private  long FileStudentId;
    private  double SubSubjectResu;
    private  String Resulet;
    private  long SemesterNewId;
    private long SectionId;

    public long getSectionId() {
        return SectionId;
    }

    public void setSectionId(long sectionId) {
        SectionId = sectionId;
    }

    public SubSubjectStudent() {
    }

    public SubSubjectStudent(long subSubjectId, long sectionId,
                             long fileStudentId, double subSubjectResu,
                             String resulet, long semesterNewId) {
        SubSubjectId = subSubjectId;
        SectionId = sectionId;
        FileStudentId = fileStudentId;
        SubSubjectResu = subSubjectResu;
        Resulet = resulet;
        SemesterNewId = semesterNewId;
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

    public long getFileStudentId() {
        return FileStudentId;
    }

    public void setFileStudentId(long fileStudentId) {
        FileStudentId = fileStudentId;
    }

    public double getSubSubjectResu() {
        return SubSubjectResu;
    }

    public void setSubSubjectResu(double subSubjectResu) {
        SubSubjectResu = subSubjectResu;
    }

    public String getResulet() {
        return Resulet;
    }

    public void setResulet(String resulet) {
        Resulet = resulet;
    }

    public long getSemesterNewId() {
        return SemesterNewId;
    }

    public void setSemesterNewId(long semesterNewId) {
        SemesterNewId = semesterNewId;
    }
}
