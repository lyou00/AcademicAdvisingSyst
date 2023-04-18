package com.student.academicadvisingsyst.AdminOP.View.ui;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;

import com.student.academicadvisingsyst.AdminOP.storage.ProgressDialog;
import com.student.academicadvisingsyst.AdminOP.storage.Validation;
import com.student.academicadvisingsyst.MainActivity;
import com.student.academicadvisingsyst.AdminOP.Models.User;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelUser;
import com.student.academicadvisingsyst.StudentOp.MainStudent;
import com.student.academicadvisingsyst.TecahrOp.MainTechar;
import com.student.academicadvisingsyst.databinding.ActivityLoginBinding;
import com.student.academicadvisingsyst.AdminOP.storage.LoginUtils;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityLoginBinding binding;
    private ViewModelUser loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ;
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       // ActionBar actionBar = getSupportActionBar();
     //   actionBar.setTitle(getResources().getString(R.string.app_name));

        binding.buttonLogin.setOnClickListener(this);
        binding.textViewSignUp.setOnClickListener(this);
        binding.forgetPassword.setOnClickListener(this);
        loginViewModel = new ViewModelProvider(this).get(ViewModelUser.class);

    }

    @Override
    protected void onStart() {
        super.onStart();
        // If user logged in, go directly to ProductActivity
        if (LoginUtils.getInstance(this).isLoggedIn()) {
          //  goToSigInActivityAdmin();
        }
    }

    String type;
    private void logInUser() {
        String email = binding.inputEmail.getText().toString();
        String password = binding.inputPassword.getText().toString();

        if (email.isEmpty()) {
            binding.inputEmail.setError(getString(R.string.email_required));
            binding.inputEmail.requestFocus();
        }

//        if (Validation.isValidEmail(email)) {
//            binding.inputEmail.setError(getString(R.string.enter_a_valid_email_address));
//            binding.inputEmail.requestFocus();
//            return;
//        }

        if (password.isEmpty()) {
            binding.inputPassword.setError(getString(R.string.password_required));
            binding.inputPassword.requestFocus();
            return;
        }

        if (!Validation.isValidPassword(password)) {
            binding.inputPassword.setError(getString(R.string.password__at_least_8_characters));
            binding.inputPassword.requestFocus();
            return;
        }

        AlertDialog alert = ProgressDialog.createAlertDialog(this);

        loginViewModel.signInUser(email,password,this);
        loginViewModel.userDat.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User users) {
                if (!loginViewModel.isError()) {

                    type=users.getUsertupe();
                    Toast.makeText(LoginActivity.this, "jhjhhj", Toast.LENGTH_SHORT).show();
                LoginUtils.getInstance(LoginActivity.this).saveUserInfo(users);
                Toast.makeText(LoginActivity.this, loginViewModel.getMessage(), Toast.LENGTH_SHORT).show();
                alert.dismiss();
                if(type.equals("متدرب")){
                    Toast.makeText(LoginActivity.this,""+users.getTechars().getTecharName(), Toast.LENGTH_SHORT).show();

                    goToSigInActivityStudentn();
                }
                   else if(type.equals("مدرب")){
                        Toast.makeText(LoginActivity.this,"skaskjakjs", Toast.LENGTH_SHORT).show();

                    goToSigInActivityTechar();
                    }
                else{
                    goToSigInActivityAdmin();

                }
            }else {
                alert.dismiss();
                    Toast.makeText(LoginActivity.this, "hjhhj", Toast.LENGTH_SHORT).show();

                    Toast.makeText(LoginActivity.this, loginViewModel.getMessage(), Toast.LENGTH_SHORT).show();
            }            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
                logInUser();
                break;
            case R.id.textViewSignUp:
                goToSigInActivityStudentn();
                break;
            case R.id.forgetPassword:
                goToPasswordAssistantActivity();
                break;
            default: // Should not get here
        }
    }

    private void goToSigInActivityTechar() {
        Intent intent = new Intent(this, MainTechar.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
    }

    private void goToSigInActivityAdmin() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    private void goToSigInActivityStudentn() {
        Intent intent = new Intent(this, MainStudent.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void goToPasswordAssistantActivity() {
        //Intent intent = new Intent(this, PasswordAssistantActivity.class);
       // startActivity(intent);
    }
}
