package com.example.myrapidfoodapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myrapidfoodapp.R;

public class PlacedOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placed_order);
    }
    public void back(View view) {
        startActivity(new Intent(PlacedOrderActivity.this, MainActivity.class));
    }
}