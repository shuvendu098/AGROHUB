package com.passonatetech.agrohub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.passonatetech.agrohub.cropcalender.CropCalender;
import com.passonatetech.agrohub.loginsignup.LoginActivity;

public class Profile extends AppCompatActivity {
	BottomNavigationView bottomNavigationView;
	Button signout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		signout=findViewById(R.id.signout);
		bottomNavigationView = findViewById(R.id.bottom_navigation);
		bottomNavigationView.setSelectedItemId(R.id.profile);

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
						startActivity(new Intent(getApplicationContext(),services.class));
						overridePendingTransition(0,0);
						return true;
					case R.id.profile:
						return true;

				}
				return true;
			}
		});
		signout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FirebaseAuth.getInstance().signOut();
				startActivity(new Intent(Profile.this, LoginActivity.class));
				Toast.makeText(Profile.this, "Sign ouT success.", Toast.LENGTH_SHORT).show();
			}
		});
	}
}