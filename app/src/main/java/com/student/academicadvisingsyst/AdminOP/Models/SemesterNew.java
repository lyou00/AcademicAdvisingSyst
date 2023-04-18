package com.student.academicadvisingsyst.AdminOP.Models;

import java.sql.Date;

public class SemesterNew {
    private String YearId;

    private long SemesterNewId;
    private long SemesterId;
    private String SemesterName;

    public String getSemesterName() {
        return SemesterName;
    }

    public void setSemesterName(String semesterName) {
        SemesterName = semesterName;
    }

    private String SemesterStDate;
    private String SemesterEndDate;
    private String SemesterStatus;


    public SemesterNew(String yearId, long semesterNewId,
                       long semesterId, String semesterStDate,
                       String semesterEndDate, String semesterStatus) {
        YearId = yearId;
        SemesterNewId = semesterNewId;
        SemesterId = semesterId;
        SemesterStDate = semesterStDate;
        SemesterEndDate = semesterEndDate;
        SemesterStatus = semesterStatus;
    }

    public SemesterNew() {
    }

    public String getYearId() {
        return YearId;
    }

    public void setYearId(String yearId) {
        YearId = yearId;
    }

    public long getSemesterNewId() {
        return SemesterNewId;
    }

    public void setSemesterNewId(long semesterNewId) {
        SemesterNewId = semesterNewId;
    }

    public long getSemesterId() {
        return SemesterId;
    }

    public void setSemesterId(long semesterId) {
        SemesterId = semesterId;
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

    public String getSemesterStatus() {
        return SemesterStatus;
    }

    public void setSemesterStatus(String semesterStatus) {
        SemesterStatus = semesterStatus;
    }
}
