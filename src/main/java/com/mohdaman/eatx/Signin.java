package com.mohdaman.eatx;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mohdaman.eatx.Common.Common;
import com.mohdaman.eatx.Model.User;
import com.rengwuxian.materialedittext.MaterialEditText;

public class Signin extends AppCompatActivity {
    EditText phone,Pnr;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        phone=(MaterialEditText)findViewById(R.id.phone);
        Pnr=(MaterialEditText)findViewById(R.id.pnr);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
         FirebaseDatabase database= FirebaseDatabase.getInstance();
         final DatabaseReference table_user=database.getReference("User");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog=new ProgressDialog(Signin.this);
              mDialog.setMessage("Please wait.....");
              mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(phone.getText().toString()).exists()) {
                            mDialog.dismiss();
                            User user = dataSnapshot.child(phone.getText().toString()).getValue(User.class);
                            if (user.getPnr().equals(Pnr.getText().toString())) {
                                Intent homeIntent=new Intent(Signin.this,Home.class);
                                Common.currentUser=user;
                                startActivity(homeIntent);
                                finish();
                            } else {
                                Toast.makeText(Signin.this, "Signed in failed!!", Toast.LENGTH_SHORT).show();

                            }
                        } else {
                            Toast.makeText(Signin.this, "User does not exist", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pnr=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.trainspnrstatus.com/"));
                startActivity(pnr);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

    }
}

