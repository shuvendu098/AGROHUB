package com.passonatetech.agrohub.cropcalender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;
import com.passonatetech.agrohub.HomePage;
import com.passonatetech.agrohub.Profile;
import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.loginsignup.ExpertRegistration;
import com.passonatetech.agrohub.loginsignup.LoginActivity;
import com.passonatetech.agrohub.services;
import com.passonatetech.agrohub.widgets.AlertBox;

import java.util.Calendar;

public class CropCalender extends AppCompatActivity  {
    BottomNavigationView bottomNavigationView;
    private String selectedDate;
    private OnDateSelectedListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_calender);
        CalendarView calendarView=findViewById(R.id.cropcalender);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.calender);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.calender:
                        return true;

                    case R.id.services:
                        startActivity(new Intent(getApplicationContext(), services.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return true;
            }
        });

        calendarView.setOnDateChangeListener(
                new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        selectedDate = year + "-" + month + "-" + dayOfMonth;
                       // mListener.onDateSelected(selectedDate);
                        clickondate();
                    }
                }
        );
    }
    public void clickondate() {
        String message = "Select One";
        Intent intent = new Intent(this, Category.class);
        Intent intent1=new Intent(this,ExpertRegistration.class);
        Createprojectpopup.showAlert(this, message, intent,intent1);
       // Toast.makeText(this, selectedDate, Toast.LENGTH_SHORT).show();

    }
    public interface OnDateSelectedListener {
        void onDateSelected(String selectedDate);
    }

    public String getSelectedDate() {
        return selectedDate;
    }

}