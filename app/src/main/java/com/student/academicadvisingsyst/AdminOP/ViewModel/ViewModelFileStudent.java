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

import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryFileStudent;
import com.student.academicadvisingsyst.AdminOP.Repository.RepositoryStudent;
import com.student.academicadvisingsyst.databinding.FragmentDashboardBinding;
import com.student.academicadvisingsyst.databinding.LaderFileStudentNewBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelFileStudent extends ViewModel {
    public MutableLiveData<List<FileStudent>> mutableLiveData = new MutableLiveData<List<FileStudent>>();


    private RepositoryStudent repository;
    public void init(){

        if(mutableLiveData != null){
            return;
        }
        repository = RepositoryStudent.getInstance();

    }


    String res;
    private EditText dateReg,edNote;
    private TextView txtSemeterId,txtStudentId;

    public FileStudent initDataBind(FragmentDashboardBinding binding){
        dateReg = binding.dateReg;
        edNote = binding.edNotnotFile;
        txtStudentId=binding.studentId;
        txtSemeterId = binding.txtSemester;
        String dateRegtxt = dateReg.getText().toString();
        String edNoteTxt = edNote.getText().toString();
        long txtSemeterIdTxt = Long.parseLong(txtSemeterId.getText().toString());
        long txtStudentIdTxt = Long.parseLong(txtStudentId.getText().toString());


        FileStudent s= new FileStudent(1,txtSemeterIdTxt,txtStudentIdTxt,dateRegtxt,edNoteTxt,1);
        return s;
    }
    public  String createSFileStudent(Context context, FragmentDashboardBinding binding) {

        RepositoryFileStudent.getInstance().createFile(initDataBind(binding)).enqueue(new Callback<FileStudent>() {
            @Override
            public void onResponse(Call<FileStudent> call, Response<FileStudent> response) {
               Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                // we are getting response from our body
                // and passing it to our modal class.
                FileStudent responseFromAPI = new FileStudent();
                responseFromAPI = response.body();
                Log.d(TAG, "onSuccess: " + response.body());

                res="onSuccess" +response.body();
              Toast.makeText(context, "i'm done " + response.headers(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<FileStudent> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res= "onFailure";
            }
        });
    return res;
    }
    public FileStudent initDataBindLader(LaderFileStudentNewBinding binding){

        String dateRegtxt = binding.dateReg.getText().toString();
        long txtLaderId = Long.parseLong(binding.txtLaderId.getText().toString());
        long txtStudentIdTxt = Long.parseLong(binding.studentId.getText().toString());


        FileStudent s= new FileStudent(1,txtLaderId,txtStudentIdTxt,dateRegtxt,"ksks",1);
        return s;
    }

    public  String createSFileStudentLader(Context context, LaderFileStudentNewBinding binding) {

        RepositoryFileStudent.getInstance().createFileLader(initDataBindLader(binding)).enqueue(new Callback<FileStudent>() {
            @Override
            public void onResponse(Call<FileStudent> call, Response<FileStudent> response) {
                Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                // we are getting response from our body
                // and passing it to our modal class.
                FileStudent responseFromAPI = new FileStudent();
                responseFromAPI = response.body();
                Log.d(TAG, "onSuccess: " + response.body());

                res="onSuccess" +response.body();
               Toast.makeText(context, "i'm done " + response.body(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<FileStudent> call, Throwable t) {
                Toast.makeText(context, "fail"+t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + t);
                res= "onFailure";
            }
        });
        return res;
    }
    public void getFilwStudent (Context context, ProgressBar bar){
        RepositoryFileStudent.getInstance().getFileStudenttData().enqueue(new Callback<List<FileStudent>>() {
            @Override
            public void onResponse(Call<List<FileStudent>> call, Response<List<FileStudent>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                }
                mutableLiveData.setValue(response.body());

                Log.d(TAG, "onResponse: " + response.body());

            }

            @Override
            public void onFailure(Call<List<FileStudent>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }

    public void getFilwStudentBySemester(Context context, ProgressBar bar,long id) {
        RepositoryFileStudent.getInstance().getFileStudenttDataSem(id).enqueue(new Callback<List<FileStudent>>() {
            @Override
            public void onResponse(Call<List<FileStudent>> call, Response<List<FileStudent>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());
                }


//                Toast.makeText(context, ""+response.body().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<FileStudent>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }

    public void getFilwStudentBylader(Context context, ProgressBar bar,long id) {
        RepositoryFileStudent.getInstance().getFileStudentByLader(id).enqueue(new Callback<List<FileStudent>>() {
            @Override
            public void onResponse(Call<List<FileStudent>> call, Response<List<FileStudent>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());
                }


//                Toast.makeText(context, ""+response.body().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<FileStudent>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }
    public void getSemesterFile(Context context, ProgressBar bar,long id) {
        RepositoryFileStudent.getInstance().getFileStudenttDataSem(id).enqueue(new Callback<List<FileStudent>>() {
            @Override
            public void onResponse(Call<List<FileStudent>> call, Response<List<FileStudent>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                }
                mutableLiveData.setValue(response.body());

                Toast.makeText(context, ""+response.body().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<FileStudent>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }

    public void getFilwStudentBySemeNot(Context context, ProgressBar bar,long id,int pid) {
        RepositoryFileStudent.getInstance().getFileStudenta(id,pid).enqueue(new Callback<List<FileStudent>>() {
            @Override
            public void onResponse(Call<List<FileStudent>> call, Response<List<FileStudent>> response) {
                if (response.isSuccessful()) {
                    bar.setVisibility(View.GONE);
                    mutableLiveData.setValue(response.body());

                }
               // mutableLiveData  = new MutableLiveData<List<FileStudent>>();

//                Toast.makeText(context, ""+response.body().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<FileStudent>> call, Throwable t) {
                Toast.makeText(context.getApplicationContext(), "failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "results: " + t);
            }
        });
    }
}






