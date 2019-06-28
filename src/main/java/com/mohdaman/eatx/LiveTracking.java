package com.mohdaman.eatx;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mohdaman.eatx.Common.Common;
import com.mohdaman.eatx.Model.Order;

public class LiveTracking extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference user;
    String DBname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_tracking);
        DBname="";
        database=FirebaseDatabase.getInstance();
        user=database.getReference("User");
        System.out.println(Common.currentUser.getName());
    }}


