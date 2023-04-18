package com.student.academicadvisingsyst.StudentOp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.student.academicadvisingsyst.AdminOP.Adapter.AdapterFileStudent;
import com.student.academicadvisingsyst.AdminOP.Models.FileStudent;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelFileStudent;
import com.student.academicadvisingsyst.AdminOP.ViewModel.ViewModelSemester;
import com.student.academicadvisingsyst.AdminOP.storage.LoginUtils;
import com.student.academicadvisingsyst.StudentOp.AdapterStudent.AdapterFileStudentStudent;
import com.student.academicadvisingsyst.StudentOp.FileStudentSemester;
import com.student.academicadvisingsyst.databinding.DashborderStudentBinding;
import com.student.academicadvisingsyst.databinding.FragmentDashboardBinding;
import com.student.academicadvisingsyst.databinding.SemesterStudentListBinding;

import java.util.List;

public class DashboardFragment extends Fragment {

   // private DashborderStudentBinding binding;
    SemesterStudentListBinding binding;
    private AdapterFileStudentStudent adapter;
    private ViewModelFileStudent viewModel;

    private ViewModelSemester viewModelS;

    FloatingActionButton fab;
    long semeterId;
    String semeterName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = SemesterStudentListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        getFile(LoginUtils.getInstance(getActivity()).getUserInfoUser().getStudent().getStudentId());

        return root;
    }
    public  void getFile(long seid){

        viewModel = new ViewModelProvider(getActivity()).get(ViewModelFileStudent.class);
        viewModel.init();

        viewModel.getFilwStudentBySemeNot(this.getActivity(),binding.progressBar,seid,9);
        //viewModel.mutableLiveData
        setRecycleView();
        viewModel.mutableLiveData.observe(getActivity(), new Observer<List<FileStudent>>() {
            @Override
            public void onChanged(List<FileStudent> fileStudents) {
                // fileStudents.addAll(fileStudents);
                adapter = new AdapterFileStudentStudent( fileStudents, getActivity(),1);
                binding.recyclerView.setAdapter(adapter);

//                for (int i = 0; i <fileStudents.size() ; i++) {
//                    Toast.makeText(context, "aa"+fileStudents.get(i).getStudentName(), Toast.LENGTH_SHORT).show();
//
//                }
                //Toast.makeText(context, "aa"+fileStudents.get(1).getFileStudentId(), Toast.LENGTH_SHORT).show();

                //adapter.updateList(fileStudents);
            }
        });



    }

    RecyclerView recyclerView;
    public void setRecycleView(){
        binding.recyclerView.setHasFixedSize(false);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       // binding = null;
    }
}