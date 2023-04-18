package com.student.academicadvisingsyst.AdminOP.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.student.academicadvisingsyst.databinding.ProfileBinding;
import com.student.academicadvisingsyst.AdminOP.storage.LoginUtils;


public class HomeFragment extends Fragment {

    private ProfileBinding binding;
    TextView textView,address,phone;
    ImageButton btExit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = ProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        textView=binding.txtusername;
        btExit=binding.btexit;
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUtils.getInstance(getContext()).clearAll();
               getActivity().finish();// finalize();;

            }
        });
        address=binding.txtaddress;
        phone=binding.txtphone;

        textView.setText(LoginUtils.getInstance(getActivity()).getUserInfo().getName());
        address.setText(LoginUtils.getInstance(getActivity()).getUserInfo().getPassword());

        phone.setText(LoginUtils.getInstance(getActivity()).getUserInfo().getUsertupe());
        final TextView textView = binding.textView25;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
       // String user= HomeFragmentArgs.fromBundle(getActivity().getIntent().getExtras()).getUser();
        //Toast.makeText(getContext(), "jjkk"+user, Toast.LENGTH_SHORT).show();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}