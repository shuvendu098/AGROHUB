package com.passonatetech.agrohub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.passonatetech.agrohub.cropcalender.CropCalender;

public class services extends AppCompatActivity {
	BottomNavigationView bottomNavigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_services);

		bottomNavigationView = findViewById(R.id.bottom_navigation);
		bottomNavigationView.setSelectedItemId(R.id.services);

		bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				switch (item.getItemId()) {
					case R.id.home:
						startActivity(new Intent(getApplicationContext(),HomePage.class));
						overridePendingTransition(0,0);
						return true;
					case R.id.calender:
						startActivity(new Intent(getApplicationContext(), CropCalender.class));
						overridePendingTransition(0,0);
						return true;
					case R.id.services:
						return true;
					case R.id.profile:
						startActivity(new Intent(getApplicationContext(),Profile.class));
						overridePendingTransition(0,0);
						return true;

				}
				return true;
			}
		});
	}
}