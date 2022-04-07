package com.example.myrapidfoodapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.myrapidfoodapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddAddressActivity extends AppCompatActivity {

    EditText number,street,ward,city,province,phone;
    Toolbar toolbar;
    Button addAddressBtn;

    FirebaseAuth auth;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        toolbar = findViewById(R.id.add_address_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        number = findViewById(R.id.ad_number);
        street = findViewById(R.id.ad_street);
        ward = findViewById(R.id.ad_ward);
        city = findViewById(R.id.ad_city);
        province = findViewById(R.id.ad_province);
        phone = findViewById(R.id.ad_phone);
        addAddressBtn = findViewById(R.id.ad_add_address);

        addAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userNumber = number.getText().toString();
                String userStreet = street.getText().toString();
                String userWard = ward.getText().toString();
                String userCity = city.getText().toString();
                String userProvince = province.getText().toString();
                String userPhone = phone.getText().toString();

                String final_address = "";

                if (!userNumber.isEmpty()){
                    final_address=final_address+userNumber+"  ";
                }
                if (!userStreet.isEmpty()){
                    final_address=final_address+userStreet+"  ";
                }
                if (!userWard.isEmpty()){
                    final_address=final_address+userWard+"  ";
                }
                if (!userCity.isEmpty()){
                    final_address=final_address+userCity+"  ";
                }
                if (!userProvince.isEmpty()){
                    final_address=final_address+userProvince+"  ";
                }
                if (!userPhone.isEmpty()){
                    final_address=final_address+userPhone+"  ";
                }
                if (!userNumber.isEmpty()  && !userStreet.isEmpty() && !userWard.isEmpty() && !userCity.isEmpty()  && !userProvince.isEmpty() && !userPhone.isEmpty()){
                    Map<String,String> map = new HashMap<>();
                    map.put("userAddress",final_address);

                    firestore.collection("CurrentUser").document(auth.getCurrentUser().getUid())
                            .collection("Address").add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(AddAddressActivity.this,"Đã thêm địa chỉ",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AddAddressActivity.this,AddressActivity.class));
                                finish();
                            }
                        }
                    });
                } else {
                    Toast.makeText(AddAddressActivity.this,"Vui lòng điền đầy đủ",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}