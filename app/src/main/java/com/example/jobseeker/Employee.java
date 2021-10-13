package com.example.jobseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseApp;
import java.util.Calendar;
import java.util.HashMap;

import java.util.Map;
import java.util.Objects;


public class Employee extends AppCompatActivity {
    public EditText editename;
    public EditText editposition;
    public EditText editpcity;
    public TextView edob;
    public EditText editecountry;
    public DatePickerDialog.OnDateSetListener mDateSetListener;
    public FirebaseApp db=FirebaseApp.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee);
        edob=findViewById(R.id.textView2);
        editename=findViewById(R.id.editText2);
        editposition=findViewById(R.id.editText4);
        editpcity=findViewById(R.id.editText8);
        editecountry=findViewById(R.id.editText9);
        Button search = findViewById(R.id.button9);
        Button enter = findViewById(R.id.button4);


        enter.setOnClickListener(v -> {
            String ename=editename.getText().toString();
            String position=editposition.getText().toString();
            String dob=edob.getText().toString();
            String pcity=editpcity.getText().toString();
            String ecountry=editecountry.getText().toString();
            Map<String,Object>map=new HashMap<>();
            map.put("employee name",ename);
            map.put("position",position);
            map.put("preferred city",pcity);
            map.put("country",ecountry);
            map.put("DOB",dob);

            db.collection("Employees").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public <DocumentReference> void onSuccess(DocumentReference documentReference) {
                    Toast.makeText(Employee.this, "Data has been stored successfully", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener((OnFailureListener) e -> Toast.makeText(Employee.this, "Error! "+e, Toast.LENGTH_SHORT).show());
        });
        edob.setOnClickListener(v -> {
            Calendar cal= Calendar.getInstance();
            int year=cal.get(Calendar.YEAR);
            int month=cal.get(Calendar.MONTH);
            int day=cal.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog=new DatePickerDialog(
                    Employee.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    mDateSetListener,
                    year,month,day);
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
        mDateSetListener= (view, year, month, dayOfMonth) -> {
            month++;
            Log.d("Employee.this","onDateset:mm/dd/yyyy"+month+"/"+dayOfMonth+"/"+year);
            String date=month+"/"+dayOfMonth+"/"+year;
            edob.setText(date);
        };
        search.setOnClickListener(v -> {
            String position=editposition.getText().toString();
            Toast.makeText(Employee.this, "Display the details", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(getBaseContext(),display.class);
            i.putExtra("pos",position);
            startActivity(i);
        });
    }


    public void search(View view) {
    }

    public void enter(View view) {
    }
}