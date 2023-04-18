package com.student.academicadvisingsyst.AdminOP.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Student  implements Parcelable, Serializable {

    long StudentId;
    String StudentName;
    String StudentAdderss;
    String StudentPhone;
    String NationalId;
    String BirthDate;
    String Sex;
    String Note;
    String StudentBarCode;

    public String getStudentBarCode() {
        return StudentBarCode;
    }

    public void setStudentBarCode(String studentBarCode) {
        StudentBarCode = studentBarCode;
    }

    public Student() {
    }


    public Student(long studentId, String studentName,
                   String studentAdderss, String studentPhone) {
        StudentId = studentId;
        StudentName = studentName;
        StudentAdderss = studentAdderss;
        StudentPhone = studentPhone;
    }

    public Student(long studentId, String studentName, String studentAdderss,
                   String studentPhone, String nationalId,
                   String birthDate, String sex, String note,String studentBarCode) {
        StudentId = studentId;
        StudentName = studentName;
        StudentAdderss = studentAdderss;
        StudentPhone = studentPhone;
        NationalId = nationalId;
        BirthDate = birthDate;
        Sex = sex;
        Note = note;
        StudentBarCode =studentBarCode;

    }

    public long getStudentId() {
        return StudentId;
    }

    public void setStudentId(long studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentAdderss() {
        return StudentAdderss;
    }

    public void setStudentAdderss(String studentAdderss) {
        StudentAdderss = studentAdderss;
    }

    public String getStudentPhone() {
        return StudentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        StudentPhone = studentPhone;
    }

    public String getNationalId() {
        return NationalId;
    }

    public void setNationalId(String nationalId) {
        NationalId = nationalId;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    protected Student(Parcel in) {
        this.StudentId = in.readLong();
        this.StudentName = in.readString();
        this.StudentAdderss = in.readString();
        this.StudentPhone = in.readString();
        this.NationalId = in.readString();
        this.BirthDate = in.readString();
        this.Sex = in.readString();
        this.Note = in.readString();
        this.StudentBarCode=in.readString();

    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public static Student newCopyOf(Student student) {
        return new Student(student.getStudentId(),
                           student.getStudentName(),
                           student.getStudentAdderss(),
                           student.getStudentPhone(),
                            student.getNationalId(),
                            student.getBirthDate(),
                            student.getSex(),
                            student.getNote(),
                            student.getStudentBarCode()

        );
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.StudentId);
        dest.writeString(this.StudentName);
        dest.writeString(this.StudentAdderss);
        dest.writeString(this.StudentPhone);
        dest.writeString(this.NationalId);
        dest.writeString(this.BirthDate);
        dest.writeString(this.Sex);
        dest.writeString(this.Note);
        dest.writeString(this.StudentBarCode);


    }

}
