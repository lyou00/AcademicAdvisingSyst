package com.student.academicadvisingsyst.AdminOP.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.student.academicadvisingsyst.AdminOP.View.DailyScheduleNew;
import com.student.academicadvisingsyst.AdminOP.View.FileStudentView;
import com.student.academicadvisingsyst.AdminOP.View.LeaderView;
import com.student.academicadvisingsyst.AdminOP.View.SectionView;
import com.student.academicadvisingsyst.AdminOP.View.SemesterView;
import com.student.academicadvisingsyst.AdminOP.View.StudentView;
import com.student.academicadvisingsyst.AdminOP.View.SubjectView;
import com.student.academicadvisingsyst.AdminOP.View.TecharsView;
import com.student.academicadvisingsyst.databinding.FragmentSettingsBinding;


public class DashboardFragment extends Fragment {

    private FragmentSettingsBinding binding;

    Context context;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.fileStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FileStudentView.class);
                startActivity(intent);
            }
        });
        binding.section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SectionView.class);
                startActivity(intent);
            }
        });
        binding.leader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), LeaderView.class);
                startActivity(intent);
            }
        });
        binding.semester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SemesterView.class);
                startActivity(intent);
            }
        });

        binding.subjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SubjectView.class);
                startActivity(intent);
            }
        });

        binding.student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), StudentView.class);
                startActivity(intent);
            }
        });
        binding.techar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getContext(), "kkdk", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), TecharsView.class);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}