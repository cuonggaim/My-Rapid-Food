package com.example.myrapidfoodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myrapidfoodapp.R;

public class WelcomeActivity extends AppCompatActivity {

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        register =(Button)findViewById(R.id.btnSignUp1);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regis= new Intent(WelcomeActivity.this, RegistrationActivity.class);
                startActivity(regis);
                finish();
            }
        });
    }

    public void SignIn1(View view) {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }
}