package com.example.jobseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Button logout = findViewById(R.id.button3);
        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(Home.this, "Logged out successfully!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Home.this,MainActivity.class));
        });
    }
}

