package com.student.academicadvisingsyst.StudentOp;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.student.academicadvisingsyst.R;
import com.student.academicadvisingsyst.databinding.ActivityMainStudentBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class MainStudent extends AppCompatActivity {

    private ActivityMainStudentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_homeS, R.id.navigation_dashboardS, R.id.navigation_notification0sS)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main_student);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}