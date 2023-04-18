package com.student.academicadvisingsyst.TecahrOp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.student.academicadvisingsyst.AdminOP.storage.LoginUtils;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.StudentOp.ui.dashboard.DashboardFragment;
import com.student.academicadvisingsyst.StudentOp.ui.dashboard.DashboardViewModel;
import com.student.academicadvisingsyst.TecahrOp.View.AttendanceView;
import com.student.academicadvisingsyst.TecahrOp.View.SectionViewTechar;
import com.student.academicadvisingsyst.TecahrOp.View.ViewStudentInSection;
import com.student.academicadvisingsyst.databinding.FragmentDashboardTecharBinding;
import com.student.academicadvisingsyst.databinding.SemesterStudentListBinding;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DashboardFragmentTechar extends Fragment {
FragmentDashboardTecharBinding binding;

long techarId;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardTecharBinding.inflate(inflater, container, false);


        View root = binding.getRoot();
        techarId=LoginUtils.getInstance(getActivity()).getUserInfoUser().getStudent().getStudentId();
        binding.section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), SectionViewTechar.class);
                intent.putExtra("techarId",techarId);
                startActivity(intent);
            }
        });
        binding.filestudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), AttendanceView.class);
                intent.putExtra("techarId",techarId);

                startActivity(intent);
            }
        });
       // getFile(LoginUtils.getInstance(getActivity()).getUserInfoUser().getStudent().getStudentId());

        return root;
    }

}


