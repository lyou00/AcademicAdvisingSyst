package com.student.academicadvisingsyst.AdminOP.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.Models.Techars;
import com.student.academicadvisingsyst.AdminOP.Models.User;

public class LoginUtils {

    private static final String SHARED_PREF_NAME = "shared_preference";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PASSWORD = "password";
    private static final String TOKEN = "token";
    private static final String IS_ADMIN = "isAdmin";
    private static final String TYPE = "Type";

    private static final String PresonId = "pid";
    private static final String PName= "pname";
    private static final String ADDRESS = "address";
    private static final String PHONE= "phobe";
    private static LoginUtils mInstance;
    private final Context mCtx;

    private LoginUtils(Context mCtx) {
        this.mCtx = mCtx;
    }

    public static synchronized LoginUtils getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new LoginUtils(mCtx);
        }
        return mInstance;
    }



    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong("id", -1) != -1;
    }

    public void saveUserInfo(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putLong(ID, user.getUserId());
        editor.putString(NAME, user.getName());
        editor.putString(PASSWORD, user.getPassword());
        editor.putBoolean(IS_ADMIN, user.isAdmin());
        editor.putString(TYPE,user.getUsertupe());
        Toast.makeText(mCtx, "ffff"+user.getTechars().getTecharName(), Toast.LENGTH_SHORT).show();

        if(user.getUsertupe().equals("متدرب")){
            editor.putLong(PresonId, user.getStudent().getStudentId());
            editor.putString(PName, user.getStudent().getStudentName());
            editor.putString(ADDRESS, user.getStudent().getStudentAdderss());
            editor.putString(PHONE, user.getStudent().getStudentPhone());
        }else if(user.getUsertupe().equals("مدرب")){
            editor.putLong(PresonId, user.getStudent().getStudentId());
            editor.putString(PName, user.getStudent().getStudentName());
            editor.putString(ADDRESS, user.getStudent().getStudentAdderss());
            editor.putString(PHONE, user.getStudent().getStudentPhone());
            Toast.makeText(mCtx, "tecvv"+user.getTechars().getTecharName(), Toast.LENGTH_SHORT).show();
        }
        else if(user.getUsertupe().equals("مرشد")){
            editor.putLong(PresonId, user.getStudent().getStudentId());
            editor.putString(PName, user.getStudent().getStudentName());
            editor.putString(ADDRESS, user.getStudent().getStudentAdderss());
            editor.putString(PHONE, user.getStudent().getStudentPhone());
        }
        editor.apply();
    }

    public User getUserInfo() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getLong(ID, -1),
                sharedPreferences.getString(NAME, null),
                sharedPreferences.getString(PASSWORD, null),
                sharedPreferences.getString(TYPE, null),
                sharedPreferences.getBoolean(IS_ADMIN, false)
        );
    }
    public User getUserInfoUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        Student student=new Student();
        student.setStudentId(sharedPreferences.getLong(PresonId, -1));
        student.setStudentName(  sharedPreferences.getString(PName, null));
        student.setStudentAdderss(  sharedPreferences.getString(ADDRESS, null));
        student.setStudentPhone(  sharedPreferences.getString(PHONE, null));
        Techars techars=new Techars();
        techars.setTecharId(sharedPreferences.getLong(PresonId, -1));
        techars.setTecharName(  sharedPreferences.getString(PName, null));
        techars.setTecharAddress(  sharedPreferences.getString(ADDRESS, null));
        techars.setTecharPhone(  sharedPreferences.getString(PHONE, null));
        return new User(
                sharedPreferences.getLong(ID, -1),
                sharedPreferences.getString(NAME, null),
                sharedPreferences.getString(PASSWORD, null),
                sharedPreferences.getString(TYPE, null),
                sharedPreferences.getBoolean(IS_ADMIN, false),

               student,techars


        );
    }

    public User getUserInfoTechar() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        Techars techars=new Techars();
        techars.setTecharId(sharedPreferences.getLong(PresonId, -1));
        techars.setTecharName(  sharedPreferences.getString(PName, null));
        techars.setTecharAddress(  sharedPreferences.getString(ADDRESS, null));
        techars.setTecharPhone(  sharedPreferences.getString(PHONE, null));

        return new User(
                sharedPreferences.getLong(ID, -1),
                sharedPreferences.getString(NAME, null),
                sharedPreferences.getString(PASSWORD, null),
                sharedPreferences.getString(TYPE, null),
                sharedPreferences.getBoolean(IS_ADMIN, false),

                techars


        );
    }

    public String getUserToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TOKEN, "");
    }

    public void clearAll() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().apply();
        editor.apply();
    }

}
