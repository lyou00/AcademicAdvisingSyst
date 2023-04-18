package com.student.academicadvisingsyst.StudentOp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.student.academicadvisingsyst.AdminOP.storage.LoginUtils;
import com.student.academicadvisingsyst.databinding.FragmentHomeBinding;
import com.student.academicadvisingsyst.databinding.ProfileTeacherBinding;


public class HomeFragment extends Fragment {

    private ProfileTeacherBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = ProfileTeacherBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUtils.getInstance(getContext()).clearAll();
                getActivity().finish();// finalize();;

            }
        });


        binding.txtusername.setText(LoginUtils.getInstance(getActivity()).getUserInfoUser().getName());
        binding.txtaddress.setText(LoginUtils.getInstance(getActivity()).getUserInfoUser().getStudent().getStudentName());


        binding.txtphone.setText(LoginUtils.getInstance(getActivity()).getUserInfoUser().getStudent().getStudentId()+"");
        final TextView textView = binding.textView25;

       // final TextView textView = binding.textHome;
       // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}