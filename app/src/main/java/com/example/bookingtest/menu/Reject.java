package com.example.bookingtest.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.bookingtest.R;
import com.example.bookingtest.adapter.AcceptAdapter;
import com.example.bookingtest.adapter.RejectAdapter;
import com.example.bookingtest.model.DataBooking;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Reject extends AppCompatActivity {

    private DatabaseReference reference;

    ArrayList<DataBooking> list;
    RejectAdapter adapter;

    private RecyclerView mRecylcler;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reject);

        mRecylcler = findViewById(R.id.list_reject);
        mRecylcler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(this);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecylcler.setLayoutManager(mManager);

        reference = FirebaseDatabase.getInstance().getReference().child("bookingRejecting");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    DataBooking da = dataSnapshot1.getValue(DataBooking.class);
                    list.add(da);
                }
                adapter = new RejectAdapter(getApplicationContext(), list);
                mRecylcler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
            }
        });

    }
}