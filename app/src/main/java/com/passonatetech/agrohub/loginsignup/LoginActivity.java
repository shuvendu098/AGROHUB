package com.passonatetech.agrohub.loginsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.passonatetech.agrohub.HomePage;
import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.cropcalender.CropCalender;

public class LoginActivity extends AppCompatActivity {
	EditText inputEmail, inputPassword;
	Button loginBtn;
	TextView forgotPassword,newUser;
	ImageView signGoogle;

	FirebaseAuth mAuth;

	//	@Override
//	public void onStart() {
//		super.onStart();
//		// Check if user is signed in (non-null) and update UI accordingly.
//		FirebaseUser currentUser = mAuth.getCurrentUser();
//		if(currentUser != null){
//			startActivity(new Intent(login.this, home.class));
//		}
//	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_page);
		inputEmail=findViewById(R.id.inputEmail);
		inputPassword=findViewById(R.id.inputPassword);
		loginBtn=(Button) findViewById(R.id.loginBtn);
		newUser=findViewById(R.id.newUser);
		forgotPassword=findViewById(R.id.forgotPassword);
		signGoogle=findViewById(R.id.signGoogle);
		signGoogle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


			}
		});


//		if (getSupportActionBar() != null) {
//			getSupportActionBar().hide();
//		}
		newUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
			}
		});





		loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String email=inputEmail.getText().toString().trim();
				String password=inputPassword.getText().toString().trim();
				mAuth=FirebaseAuth.getInstance();
				if(email.isEmpty() )
					Toast.makeText(LoginActivity.this, "Enter Email.", Toast.LENGTH_SHORT).show();
				else if(password.isEmpty())
					Toast.makeText(LoginActivity.this, "Enter Password.", Toast.LENGTH_SHORT).show();
				else login(email, password);

			}
		});

	}

	private void login(String email, String password) {
		mAuth.signInWithEmailAndPassword(email, password)
				.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						if (task.isSuccessful()) {
							FirebaseUser user = mAuth.getCurrentUser();
							Toast.makeText(LoginActivity.this, "Signup Success.", Toast.LENGTH_SHORT).show();
							startActivity(new Intent(LoginActivity.this, HomePage.class));
							finish();
						} else {
							Toast.makeText(LoginActivity.this, "Authentication failed.",
									Toast.LENGTH_SHORT).show();
						}
					}
				});
	}

}