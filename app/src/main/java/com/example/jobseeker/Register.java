package com.example.jobseeker;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private EditText email;
    private EditText password;

    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        email=findViewById(R.id.editText6);
        password=findViewById(R.id.editText5);
        Button register = findViewById(R.id.button2);
        TextView text = findViewById(R.id.textView2);
        mAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(v -> {
            String txt_email=email.getText().toString();
            String txt_password=password.getText().toString();
            if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password)){
                Toast.makeText(Register.this, "Complete the credentials", Toast.LENGTH_SHORT).show();
            }
            else
            if(txt_password.length()<6)
            {
                Toast.makeText(Register.this, "Password is short!", Toast.LENGTH_SHORT).show();
            }
            else
                registerUser(txt_email,txt_password);


        });
        text.setOnClickListener(v -> {
            Intent i=new Intent(Register.this,Login.class);
            startActivity(i);
        });

    }

    private void registerUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, task -> {
            if(task.isSuccessful())
            {
                Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Register.this,Main.class));
                finish();
            }
            else
            {
                Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
            }
        }
        );


    }}
