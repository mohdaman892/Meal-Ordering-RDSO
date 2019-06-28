package com.mohdaman.eatx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mohdaman.eatx.Interface.ItemClickListener;
import com.mohdaman.eatx.Model.Food;
import com.mohdaman.eatx.ViewHolder.FoodViewHolder;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {
    RecyclerView recycler_food;
    RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference foodList;
    String CategoryId="";
    FirebaseRecyclerAdapter<Food,FoodViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        database = FirebaseDatabase.getInstance();
        foodList = database.getReference("Foods");
        recycler_food= (RecyclerView) findViewById(R.id.recycler_food);
        recycler_food.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler_food.setLayoutManager(layoutManager);
        if(getIntent() !=null)
            CategoryId=getIntent().getStringExtra("CategoryId");
        if(!CategoryId.isEmpty()&& CategoryId!=null)
        {
            loadListFood(CategoryId);

        }

    }

    private void loadListFood(String CategoryId) {
        adapter=new FirebaseRecyclerAdapter<Food, FoodViewHolder>(Food.class,
                R.layout.food_item,
                FoodViewHolder.class,
                foodList.orderByChild("menuId").equalTo(CategoryId)
                ) {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder, Food model, int position) {
                viewHolder.food_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.food_image);
                final Food local=model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent FoodDetail=new Intent(FoodList.this,FoodDetail.class);
                        FoodDetail.putExtra("FoodId", adapter.getRef(position).getKey());
                        startActivity(FoodDetail);
                    }
                });
            }
        };
    recycler_food.setAdapter(adapter);
    }
}
