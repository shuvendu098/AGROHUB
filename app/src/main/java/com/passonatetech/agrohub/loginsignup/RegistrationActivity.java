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

public class RegistrationActivity extends AppCompatActivity {


    FirebaseAuth mAuth;
    EditText editEmail,editPassword, UserName;
    Button signup;
    ImageView signgoogle;
    TextView login;
    	@Override
	public void onStart() {
		super.onStart();
		FirebaseUser currentUser = mAuth.getCurrentUser();
		if(currentUser != null){
			startActivity(new Intent(RegistrationActivity.this, HomePage.class));
		}
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);
        mAuth=FirebaseAuth.getInstance();
        UserName=findViewById(R.id.UserName);
        editEmail=findViewById(R.id.emailUser);
        editPassword=findViewById(R.id.emailUser);
        signup=findViewById(R.id.signUp);


        signgoogle=findViewById(R.id.googlelogin);
        signgoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//             code  to auth using google.
            }
        });


        login=findViewById(R.id.loginRd);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            }
        });


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=UserName.getText().toString().trim();
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                if (name.isEmpty())
                    Toast.makeText(RegistrationActivity.this, "Enter Name.", Toast.LENGTH_SHORT).show();
                else if (email.isEmpty())
                    Toast.makeText(RegistrationActivity.this, "Enter Email.", Toast.LENGTH_SHORT).show();
                else if (password.isEmpty())
                    Toast.makeText(RegistrationActivity.this, "Enter Password.", Toast.LENGTH_SHORT).show();
                else singup(email, password);

            }
        });




    }

    private void singup(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(RegistrationActivity.this, "Signup Success.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this, HomePage.class));
                            finish();

                        } else {
                            Toast.makeText(RegistrationActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
//        mAuth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            Toast.makeText(RegistrationActivity.this, "Signup Success.", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(RegistrationActivity.this, HomePage.class));
//                        } else {
//                            Toast.makeText(RegistrationActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
    }

}