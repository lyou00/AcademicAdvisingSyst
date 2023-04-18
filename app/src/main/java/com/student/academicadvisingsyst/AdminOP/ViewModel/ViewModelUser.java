package com.student.academicadvisingsyst.AdminOP.ViewModel;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.student.academicadvisingsyst.AdminOP.Models.User;
import com.student.academicadvisingsyst.AdminOP.Models.Student;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryStudent;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryUser;
import com.student.academicadvisingsyst.databinding.AddStudentBinding;
import com.student.academicadvisingsyst.databinding.AddUserNewBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelUser extends ViewModel {
    public MutableLiveData<List<User>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<User> userDat = new MutableLiveData<>();

    private RepositoryStudent repository;
    private boolean error;
    private String message;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void init() {

        if (mutableLiveData != null) {
            return;
        }
        repository = RepositoryStudent.getInstance();

    }


    String res;
    private EditText txtUserName, txtPassword, txtPasswordRe;
    private TextView txtId,txtTypeId;

    public User initDataBind(AddUserNewBinding binding) {
        txtUserName = binding.txtUserName;
        txtPassword = binding.txtPassword;
        txtPasswordRe = binding.txtPasswordRe;
        txtId = binding.txtId;
        txtTypeId = binding.txtTypeId;
        //edPhone = addStudentBinding.edPhone;
        String username = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
        String passwordre = txtPasswordRe.getText().toString();
        long Id = Long.parseLong(txtId.getText().toString());
        String type = (txtTypeId.getText().toString());


        User s= new User();
        s.setName(username);
        s.setPassword(password);
        s.setAdmin(false);
        s.setId(Id);
        s.setUsertupe(type);
        return s;
    }

    public String createUser(Context context, AddUserNewBinding binding) {

        RepositoryUser.getInstance().createUser(initDataBind(binding)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                // we are getting response from our body
                // and passing it to our modal class.
                User responseFromAPI = new User();
                responseFromAPI = response.body();
                Log.d(TAG, "onSuccess: " + response.body());

                res = "onSuccess" + response.body();
               // Toast.makeText(context, "i'm done " + response.headers(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(context, "fail" + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res = "onFailure";
            }
        });
        return res;
    }

    public void getStudent(Context context, ProgressBar bar) {
        RepositoryUser.getInstance().getUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                }
                mutableLiveData.setValue(response.body());
                Toast.makeText(context.getApplicationContext(), "failure" + response.body(), Toast.LENGTH_SHORT).show();

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }

    User user = new User();

    public void signInUser(String un, String pass, Context context) {
        RepositoryUser.getInstance().signUser(un, pass).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "onResponse: done");
                if (response.isSuccessful()) {
//                    Log.d(TAG, "onResponse: " + response.body().getAccess_token());
              //      Log.d(TAG, "onResponse: " + response.body().toString());
                    Log.d(TAG, "onResponse: " + response.raw());

                    setMessage("Success");
//                    Toast.makeText(context, response.body().getAccess_token(), Toast.LENGTH_LONG).show();
                    userDat.setValue( response.body());
                    setError(true);


                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(context, "ghgg"+t.getMessage(), Toast.LENGTH_LONG).show();
                setMessage("Falier");
                setError(false);

                //  getUserData(response.body().getAccess_token(),view);
            }
        });
    }
}

