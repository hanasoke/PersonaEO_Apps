package com.example.bookingtest.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bookingtest.R;

public class DetailWait extends AppCompatActivity {

    TextView vcompany, vdate, vemail, vloc, vmessage, vname, vpeople;

    String company, date, email, loc, message, name, people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wait);

        vname = findViewById(R.id.tv_nama);
        vcompany = findViewById(R.id.tv_company);
        vemail = findViewById(R.id.tv_email);
        vdate = findViewById(R.id.tv_date);
        vloc = findViewById(R.id.tv_location);
        vpeople = findViewById(R.id.tv_people);
        vmessage = findViewById(R.id.tv_message);

        name = getIntent().getStringExtra("NAME_BOOKING");
        company = getIntent().getStringExtra("COMPANY_BOOKING");
        email = getIntent().getStringExtra("EMAIL_BOOKING");
        date = getIntent().getStringExtra("DATE_BOOKING");
        loc = getIntent().getStringExtra("LOCATION_BOOKING");
        people = getIntent().getStringExtra("PEOPLE_BOOKING");
        message = getIntent().getStringExtra("MESSAGE_BOOKING");

//        Set Text
        vname.setText(name);
        vcompany.setText(company);
        vemail.setText(email);
        vdate.setText(date);
        vloc.setText(loc);
        vpeople.setText(people);
        vmessage.setText(message);
    }
}