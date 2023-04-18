package com.student.academicadvisingsyst;

import static com.student.academicadvisingsyst.R.id.nav_host_fragment_activity_main4;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.student.academicadvisingsyst.AdminOP.Models.User;
import com.student.academicadvisingsyst.databinding.ActivityMain4Binding;

public class MainActivity extends AppCompatActivity {

    private ActivityMain4Binding binding;
    Intent intent;
    User user;

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = this.getIntent().getExtras();
        if (b != null)
            user = (User) b.getSerializable("user");
    //  User user= (User) getIntent().getSerializableExtra("user");
      //  Toast.makeText(this, "user"+user.getStudent().getStudentName(), Toast.LENGTH_SHORT).show();
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
//        bundle.putString("user","uuuuu");

        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        NavController navController = Navigation.findNavController(this, nav_host_fragment_activity_main4);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}