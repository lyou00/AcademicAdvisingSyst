package com.student.academicadvisingsyst.AdminOP.Models;

public class Courses {

     
    private String CoursesName ;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private long CoursesId ;
    private long SubjectsId ;
    private String CoursesType ;
    private long CoursesParentId ;
    private String CoursesCode ;

    public Courses(String coursesName,
                   long coursesId,
                   long subjectsId, String coursesType,
                   long coursesParentId, String coursesCode) {
        CoursesName = coursesName;
        CoursesId = coursesId;
        SubjectsId = subjectsId;
        CoursesType = coursesType;
        CoursesParentId = coursesParentId;
        CoursesCode = coursesCode;
    }

    public Courses() {
    }

    public String getCoursesName() {
        return CoursesName;
    }

    public void setCoursesName(String coursesName) {
        CoursesName = coursesName;
    }

    public long getCoursesId() {
        return CoursesId;
    }

    public void setCoursesId(long coursesId) {
        CoursesId = coursesId;
    }

    public long getSubjectsId() {
        return SubjectsId;
    }

    public void setSubjectsId(long subjectsId) {
        SubjectsId = subjectsId;
    }

    public String getCoursesType() {
        return CoursesType;
    }

    public void setCoursesType(String coursesType) {
        CoursesType = coursesType;
    }

    public long getCoursesParentId() {
        return CoursesParentId;
    }

    public void setCoursesParentId(long coursesParentId) {
        CoursesParentId = coursesParentId;
    }

    public String getCoursesCode() {
        return CoursesCode;
    }

    public void setCoursesCode(String coursesCode) {
        CoursesCode = coursesCode;
    }
}
