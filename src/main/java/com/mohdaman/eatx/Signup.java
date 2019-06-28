package com.mohdaman.eatx;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mohdaman.eatx.Model.User;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.jar.Attributes;

public class Signup extends AppCompatActivity {
    EditText phone, name, pnr;
    String dbphone,dbname;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dbphone="";
        dbname="";
        phone = (MaterialEditText) findViewById(R.id.phone);
        name = (MaterialEditText) findViewById(R.id.name);
        pnr = (MaterialEditText) findViewById(R.id.pnr);
        button1 = (Button) findViewById(R.id.button1);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(Signup.this);
                mDialog.setMessage("Please wait.....");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(phone.getText().toString()).exists()){}

                        else{
                            mDialog.dismiss();
                            User user=new User(name.getText().toString(),pnr.getText().toString(),phone.getText().toString(),dbphone,dbname);
                            table_user.child(phone.getText().toString()).setValue(user);
                            Toast.makeText(Signup.this, "Sign Up Successfull!!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
