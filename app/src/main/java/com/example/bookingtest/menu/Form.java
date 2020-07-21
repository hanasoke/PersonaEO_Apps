package com.example.bookingtest.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookingtest.MainActivity;
import com.example.bookingtest.R;
import com.example.bookingtest.model.DataBooking;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Form extends AppCompatActivity {

    EditText perusahaan, tanggal, textEmail, lokasi, pesan, nama, orang;
    Button buttonAdd, back;

//    untuk date picker
    DatePickerDialog.OnDateSetListener setListener;
    DatabaseReference databaseBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        databaseBooking = FirebaseDatabase.getInstance().getReference("booking");

        nama = (EditText) findViewById(R.id.editTextName);
        perusahaan = (EditText) findViewById(R.id.editTextCompany);
        textEmail =  (EditText) findViewById(R.id.editTextEmail);
        lokasi = (EditText) findViewById(R.id.editTextLocation);
        orang = (EditText) findViewById(R.id.editTextPeople);
        tanggal = (EditText) findViewById(R.id.editTextDate);
        pesan = (EditText) findViewById(R.id.editTextMessage);
        buttonAdd = (Button) findViewById(R.id.buttonAddBooking);

        Button btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goRegister = new Intent(Form.this, MainActivity.class);
                startActivity(goRegister);
                finish();
            }
        });

        //untuk datepicker
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog mDate = new DatePickerDialog(Form.this, date, year, month, day);
                mDate.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                mDate.show();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nama.getText().toString().trim();
                String company = perusahaan.getText().toString().trim();
                String email = textEmail.getText().toString().trim();
                String location = lokasi.getText().toString().trim();
                String people = orang.getText().toString().trim();
                String date = tanggal.getText().toString().trim();
                String message = pesan.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                //people
                int x = Integer.parseInt(people);

                if (name.isEmpty()){
                    nama.setError("Enter Your Name");;
                }
                else if (company.isEmpty()){
                    perusahaan.setError("Enter Your Company Name");
                }
                else if (email.isEmpty()){
                    textEmail.setError("Enter Your Email");
                }
                else if (!email.matches(emailPattern)) {
                    textEmail.setError("Please Enter Invalid Email");
                }
                else if (location.isEmpty()){
                    lokasi.setError("Enter Your City Location Event");
                }
                else if (people.isEmpty()){
                    orang.setError("How People Join Your Event");
                }
                else if (date.isEmpty()){
                    tanggal.setError("Enter Your Date Event");
                }
                else if (message.isEmpty()){
                    pesan.setError("Enter Your Description About Your Event");
                }
                else {
                    if (x>=30){
                        addBooking();
                    } else {
                        Toast.makeText(Form.this, "Should be More Than 30 people", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    private void addBooking(){
        String name = nama.getText().toString().trim();
        String company = perusahaan.getText().toString().trim();
        String email = textEmail.getText().toString().trim();
        String location = lokasi.getText().toString().trim();
        String people = orang.getText().toString().trim();
        String date = tanggal.getText().toString().trim();
        String message = pesan.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){

            String id = databaseBooking.push().getKey();

            DataBooking booking = new  DataBooking(name, company, email, location, people, date, message);

            databaseBooking.child(id).setValue(booking);

            Toast.makeText(this,"Booking Success", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }else {
            Toast.makeText(this, "Yo Should enter a name", Toast.LENGTH_LONG).show();
        }
    }
    final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            view.setMinDate(System.currentTimeMillis() - 1000);
            String date = year+"/"+monthOfYear+"/"+dayOfMonth;
            tanggal.setText(date);
        }
    };
}