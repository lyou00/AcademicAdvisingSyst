package com.student.academicadvisingsyst.AdminOP.Models;

public class DailySchedule {


    public long SectionId ;
    public String TimeOf ;
    public String TimeTo ;

    public long DailyScheduleId ;
    public long DayId ;
    private  String DayName;
    public String Status ;
    public String Note ;


    public String YearId ;

    public DailySchedule() {
    }

    public String getDayName() {
        return DayName;
    }

    public void setDayName(String dayName) {
        DayName = dayName;
    }

    public DailySchedule(long sectionId, String timeOf, String timeTo,
                         long dailyScheduleId, String dayName, String status, String note, String yearId) {
        SectionId = sectionId;
        TimeOf = timeOf;
        TimeTo = timeTo;
        DailyScheduleId = dailyScheduleId;
        DayName = dayName;
        Status = status;
        Note = note;
        YearId = yearId;
    }

    public long getSectionId() {
        return SectionId;
    }

    public void setSectionId(long sectionId) {
        SectionId = sectionId;
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

    public long getDailyScheduleId() {
        return DailyScheduleId;
    }

    public void setDailyScheduleId(long dailyScheduleId) {
        DailyScheduleId = dailyScheduleId;
    }

    public long getDayId() {
        return DayId;
    }

    public void setDayId(long dayId) {
        DayId = dayId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getYearId() {
        return YearId;
    }

    public void setYearId(String yearId) {
        YearId = yearId;
    }
}
