package com.example.myrapidfoodapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myrapidfoodapp.R;

import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity{

    int amount = 0;
    Toolbar toolbar;
    TextView subTotal, shipping, total;
    Button paymentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        toolbar = findViewById(R.id.payment_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        amount = getIntent().getIntExtra("amount",0);

        subTotal = findViewById(R.id.sub_total);
        shipping = findViewById(R.id.shipping);
        total = findViewById(R.id.total_amt);
        paymentBtn = findViewById(R.id.pay_btn);

        subTotal.setText(amount+" VND ");
        shipping.setText("15000 VND");
        total.setText(amount-15000 + "VND");

        paymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, "Thanh toán thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PaymentActivity.this, PlacedOrderActivity.class));
                finish();
            }
        });

    }
}