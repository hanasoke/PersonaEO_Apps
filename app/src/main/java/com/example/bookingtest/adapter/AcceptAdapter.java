package com.example.bookingtest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtest.R;
import com.example.bookingtest.detail.DetailAccept;
import com.example.bookingtest.model.DataBooking;

import java.util.ArrayList;


public class AcceptAdapter extends RecyclerView.Adapter<AcceptAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<DataBooking> dataBookings;

    public AcceptAdapter(Context cont, ArrayList<DataBooking> data) {
        context = cont;
        dataBookings = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_accept, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.vcompany.setText(dataBookings.get(position).getCompany());
        holder.vlocation.setText(dataBookings.get(position).getLoc());
        holder.vdate.setText(dataBookings.get(position).getDate());

        holder.btndetail.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent detail = new Intent(context.getApplicationContext(), DetailAccept.class);

                detail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                detail.putExtra("NAME_BOOKING", dataBookings.get(position).getName());
                detail.putExtra("COMPANY_BOOKING", dataBookings.get(position).getCompany());
                detail.putExtra("EMAIL_BOOKING", dataBookings.get(position).getEmail());
                detail.putExtra("DATE_BOOKING", dataBookings.get(position).getDate());
                detail.putExtra("LOCATION_BOOKING", dataBookings.get(position).getLoc());
                detail.putExtra("PEOPLE_BOOKING", dataBookings.get(position).getPeople());
                detail.putExtra("STATUS_BOOKING", dataBookings.get(position).getStatus());
                detail.putExtra("MESSAGE_BOOKING", dataBookings.get(position).getMessage());

                context.startActivity(detail);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBookings.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView vcompany, vlocation, vdate;
        Button btndetail;

        public MyViewHolder(View itemView) {
            super(itemView);

            vcompany = itemView.findViewById(R.id.tv_company);
            vlocation = itemView.findViewById(R.id.tv_location);
            vdate = itemView.findViewById(R.id.tv_date);
            btndetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
