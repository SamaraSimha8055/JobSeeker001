package com.example.jobseeker;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class Main extends AppCompatActivity {
    //First we must create a variable for the activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_frame);
        Button buttonA = findViewById(R.id.button);
        buttonA.setOnClickListener(v -> openActivityLogin());
        //on clicking the button
        Button buttonB = findViewById(R.id.button_company);
        buttonB.setOnClickListener(v -> openActivityEmployer());


    }
    public void openActivityLogin()
    {
        Intent intent=new Intent(Main.this,Home.class);

        startActivity(intent);
    }
    public void openActivityEmployer()
    {
        Intent intent1=new Intent(Main.this,EmployerActivity.class);
        startActivity(intent1);
    }

}
