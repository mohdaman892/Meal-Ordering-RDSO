package com.mohdaman.eatx;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mohdaman.eatx.Database.Database;
import com.mohdaman.eatx.Model.Food;
import com.mohdaman.eatx.Model.Order;
import com.squareup.picasso.Picasso;

public class FoodDetail extends AppCompatActivity {
    TextView food_name,food_price;
    ImageView food_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;
String foodId="";
String DBPhone="";
String DBName="";
FirebaseDatabase database;
DatabaseReference foods;
Food currentFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        database=FirebaseDatabase.getInstance();
        foods=database.getReference("Foods");
        numberButton=(ElegantNumberButton)findViewById(R.id.number_button);
        btnCart=(FloatingActionButton)findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            new Database(getBaseContext()).addToCart(new Order(
                    foodId,
                    currentFood.getName(),
                    numberButton.getNumber(),
                    currentFood.getPrice(),
                    DBPhone,
                    DBName
            ));
            Toast.makeText(FoodDetail.this,"Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
        food_name=(TextView)findViewById(R.id.food_name);
        food_price=(TextView)findViewById(R.id.food_price);
        food_image=(ImageView) findViewById(R.id.img_food);
        collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsing);
        if(getIntent() !=null)
            foodId=getIntent().getStringExtra("FoodId");
        if(!foodId.isEmpty())
        {
            getDetailFood(foodId);

        }
    }

    private void getDetailFood(String foodId) {
foods.child(foodId).addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange( DataSnapshot dataSnapshot) {
        currentFood= dataSnapshot.getValue(Food.class);
        Picasso.with(getBaseContext()).load(currentFood.getImage())
                .into(food_image);
        collapsingToolbarLayout.setTitle(currentFood.getName());
food_price.setText(currentFood.getPrice());
        food_name.setText(currentFood.getName());

    }

    @Override
    public void onCancelled( DatabaseError databaseError) {

    }
});

    }
}
