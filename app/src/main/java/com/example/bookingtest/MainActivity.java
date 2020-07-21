package com.example.bookingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bookingtest.menu.Accept;
import com.example.bookingtest.menu.Complete;
import com.example.bookingtest.menu.Form;
import com.example.bookingtest.menu.Reject;
import com.example.bookingtest.menu.Wait;
import com.example.bookingtest.menu.Website;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CardView form;
    CardView accept;
    CardView reject;
    CardView complete;
    CardView wait;
    CardView website;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        form = findViewById(R.id.card_form);
        form.setOnClickListener(this);

        wait = findViewById(R.id.waiting_list);
        wait.setOnClickListener(this);

        accept = findViewById(R.id.booking_accept);
        accept.setOnClickListener(this);

        reject = findViewById(R.id.booking_reject);
        reject.setOnClickListener(this);

        complete = findViewById(R.id.booking_complete);
        complete.setOnClickListener(this);

        website = findViewById(R.id.visit_website);
        website.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.card_form:
                Intent form = new Intent(this, Form.class);
                startActivity(form);
                break;
            case R.id.waiting_list:
                Intent wait = new Intent(this, Wait.class);
                startActivity(wait);
                break;

            case R.id.booking_accept:
                Intent accept = new Intent(this, Accept.class);
                startActivity(accept);
                break;

            case R.id.booking_reject:
                Intent reject = new Intent(this, Reject.class);
                startActivity(reject);
                break;

            case R.id.booking_complete:
                Intent complete = new Intent(this, Complete.class);
                startActivity(complete);
                break;

            case R.id.visit_website:
                Intent website = new Intent(this, Website.class);
                startActivity(website);
                break;
        }
    }

}