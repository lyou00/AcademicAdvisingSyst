package com.student.academicadvisingsyst.AdminOP.Models;

import com.google.gson.annotations.SerializedName;

public class FileStudent {


    private long SemesterNewId;

    private long FileStudentId;
    private long StudentId;
    private String FileDateReg;

    private String FileNote;
    private int FileStat;

    Student student=new Student();
    @SerializedName("StudentName")
    private String StudentName;
    private String SemesterStDate;
    private String SemesterEndDate;
    private String YearId;
    private String SemesterName;
    private Long SemesterId;


    private Long SubLaderId ;
    private Long TecharId ;
    private String DateLader ;
    private String TecharsName;
    private String TecharsPhone;

    private String TecharsAdderss;

    public Long getSubLaderId() {
        return SubLaderId;
    }

    public void setSubLaderId(Long subLaderId) {
        SubLaderId = subLaderId;
    }

    public Long getTecharId() {
        return TecharId;
    }

    public void setTecharId(Long techarId) {
        TecharId = techarId;
    }

    public String getDateLader() {
        return DateLader;
    }

    public void setDateLader(String dateLader) {
        DateLader = dateLader;
    }

    public String getTecharsName() {
        return TecharsName;
    }

    public void setTecharsName(String techarsName) {
        TecharsName = techarsName;
    }

    public String getTecharsPhone() {
        return TecharsPhone;
    }

    public void setTecharsPhone(String techarsPhone) {
        TecharsPhone = techarsPhone;
    }

    public String getTecharsAdderss() {
        return TecharsAdderss;
    }

    public void setTecharsAdderss(String techarsAdderss) {
        TecharsAdderss = techarsAdderss;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSemesterStDate() {
        return SemesterStDate;
    }

    public void setSemesterStDate(String semesterStDate) {
        SemesterStDate = semesterStDate;
    }

    public String getSemesterEndDate() {
        return SemesterEndDate;
    }

    public void setSemesterEndDate(String semesterEndDate) {
        SemesterEndDate = semesterEndDate;
    }

    public String getYearId() {
        return YearId;
    }

    public void setYearId(String yearId) {
        YearId = yearId;
    }

    public String getSemesterName() {
        return SemesterName;
    }

    public void setSemesterName(String semesterName) {
        SemesterName = semesterName;
    }

    public Long getSemesterId() {
        return SemesterId;
    }

    public void setSemesterId(Long semesterId) {
        SemesterId = semesterId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public FileStudent( long fileStudentId,long semesterNewId,
                        long studentId, String fileDateReg, String fileNote, int fileStat) {
        SemesterNewId = semesterNewId;
        FileStudentId = fileStudentId;
        StudentId = studentId;
        FileDateReg = fileDateReg;
        FileNote = fileNote;
        FileStat = fileStat;
    }

    public FileStudent() {
    }

    public long getSemesterNewId() {
        return SemesterNewId;
    }

    public void setSemesterNewId(long semesterNewId) {
        SemesterNewId = semesterNewId;
    }

    public long getFileStudentId() {
        return FileStudentId;
    }

    public void setFileStudentId(long fileStudentId) {
        FileStudentId = fileStudentId;
    }

    public long getStudentId() {
        return StudentId;
    }

    public void setStudentId(long studentId) {
        StudentId = studentId;
    }

    public String getFileDateReg() {
        return FileDateReg;
    }

    public void setFileDateReg(String fileDateReg) {
        FileDateReg = fileDateReg;
    }

    public String getFileNote() {
        return FileNote;
    }

    public void setFileNote(String fileNote) {
        FileNote = fileNote;
    }

    public int getFileStat() {
        return FileStat;
    }

    public void setFileStat(int fileStat) {
        FileStat = fileStat;
    }
}
