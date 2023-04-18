package com.student.academicadvisingsyst.AdminOP.Models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("UserId")
    private long UserId;
    private long Id;



    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @SerializedName("UserName")

    private String name;
    @SerializedName("Password")

    private String password;

    private boolean isAdmin;


    @SerializedName("UserType")

    String usertupe;
    boolean Status;
    String avatar;

    String access_token;

    Student student=new Student();
    @SerializedName("techars")
    Techars techars=new Techars();

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Techars getTechars() {
        return techars;
    }

    public void setTechars(Techars techars) {
        this.techars = techars;
    }

    public User() {

    }

    public User(long UserId, String name, String password,
                String usertupe, boolean status) {
        this.UserId = UserId;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
        this.usertupe = usertupe;
        Status = status;
        this.avatar = avatar;
        this.access_token = access_token;
    }

    public User(long UserId, String name, String password,
                String usertupe, boolean status,Student student,Techars techars) {
        this.UserId = UserId;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
        this.usertupe = usertupe;
        Status = status;
        this.avatar = avatar;
        this.access_token = access_token;
        this.student=student;
        this.techars=techars;

    }
    public User(long UserId, String name, String password,
                String usertupe, boolean status,Techars techars) {
        this.UserId = UserId;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
        this.usertupe = usertupe;
        Status = status;
        this.avatar = avatar;
        this.access_token = access_token;
        this.techars=techars;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        this.UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUsertupe() {
        return usertupe;
    }

    public void setUsertupe(String usertupe) {
        this.usertupe = usertupe;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
