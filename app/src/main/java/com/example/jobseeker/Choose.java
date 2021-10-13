package com.example.jobseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Choose extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
        Button employee = findViewById(R.id.button8);
        Button employer = findViewById(R.id.button7);
        employee.setOnClickListener(v -> {
            startActivity(new Intent(Choose.this,Employee.class));
            finish();
            Toast.makeText(Choose.this, "Successful!!", Toast.LENGTH_SHORT).show();
        });
        employer.setOnClickListener(v -> {
            startActivity(new Intent(Choose.this,Employer.class));
            finish();
            Toast.makeText(Choose.this, "Successful!!", Toast.LENGTH_SHORT).show();
        });
    }
}
