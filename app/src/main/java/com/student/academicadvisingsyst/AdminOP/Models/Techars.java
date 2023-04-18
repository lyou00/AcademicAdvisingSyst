package com.student.academicadvisingsyst.AdminOP.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Techars  implements Parcelable , Serializable {



    private long TecharId;
    private String TecharName;
    private String TecharPhone;
    private String TecharAddress;
    private String Specialization ;

    private  long UserId;

    @SerializedName("TypeChar")
    public String TypeChar;
    private String Sex ;
    private String NationalId ;
    private String Note ;

    private int TecharType;

    public int getTecharType() {
        return TecharType;
    }

    public void setTecharType(int techarType) {
        TecharType = techarType;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public Techars(long techarsId, String techarName,
                   String techarsPhone, String techarsAddress,
                   String specialization, int techarstype, String type

                   ) {
        TecharId = techarsId;
        TecharName = techarName;
        TecharPhone = techarsPhone;
        TecharAddress = techarsAddress;
        Specialization = specialization;
        TecharType=techarstype;
        TypeChar=type;

    }

    public Techars(long techarsId, String techarName,
                   String techarPhone, String techarsAdderss,
                   String specialization, int techarType,
                   String typeChar, String sex,
                   String nationalId, String note
                  ) {
        TecharId = techarsId;
        TecharName = techarName;
        TecharPhone = techarPhone;
        TecharAddress = techarsAdderss;
        Specialization = specialization;
        TypeChar = typeChar;
        Sex = sex;
        NationalId = nationalId;
        Note = note;
        TecharType = techarType;
    }

    public Techars() {
    }

    public String getTypeChar() {
        return TypeChar;
    }

    public void setTypeChar(String typeChar) {
        TypeChar = typeChar;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getNationalId() {
        return NationalId;
    }

    public void setNationalId(String nationalId) {
        NationalId = nationalId;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public long getTecharId() {
        return TecharId;
    }

    public void setTecharId(long techarId) {
        TecharId = techarId;
    }

    public String getTecharName() {
        return TecharName;
    }

    public void setTecharName(String techarName) {
        TecharName = techarName;
    }

    public String getTecharPhone() {
        return TecharPhone;
    }

    public void setTecharPhone(String techarPhone) {
        TecharPhone = techarPhone;
    }

    public String getTecharAddress() {
        return TecharAddress;
    }

    public void setTecharAddress(String techarAddress) {
        TecharAddress = techarAddress;
    }



    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }



    public Techars mInfo;


    protected Techars(Parcel in) {
        this.TecharId = in.readLong();
        this.TecharName = in.readString();
        this.TypeChar = in.readString();

        this.TecharAddress = in.readString();
        this.TecharPhone = in.readString();
        this.TecharType=in.readInt();
        this.TypeChar = in.readString();
        this.Sex = in.readString();
        this.NationalId = in.readString();
        this.Note = in.readString();
        this.UserId = in.readLong();


    }

    public static final Creator<Techars> CREATOR = new Creator<Techars>() {
        @Override
        public Techars createFromParcel(Parcel in) {
            return new Techars(in);
        }

        @Override
        public Techars[] newArray(int size) {
            return new Techars[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public static Techars newCopyOf(Techars techars) {
        return new Techars(techars.getTecharId(),
               techars.getTecharName(),techars.getTecharAddress(),
                techars.getTecharPhone(),techars.getSpecialization(),
                techars.getTecharType(),techars.getTypeChar(),techars.getNationalId(),
                techars.getSex(),techars.getNote()
                    );
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.TecharId);
        dest.writeString(this.TecharName);
        dest.writeString(this.TypeChar);

        dest.writeString(this.getTecharAddress());
        dest.writeString(this.getTecharPhone());
        dest.writeString(this.getSpecialization());
        dest.writeInt(this.getTecharType());

        dest.writeString(this.getSex());
        dest.writeString(this.getNationalId());
        dest.writeString(this.getNote());
        dest.writeLong(this.getUserId());



    }



}
