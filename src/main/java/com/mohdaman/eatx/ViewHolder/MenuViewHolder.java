package com.mohdaman.eatx.ViewHolder;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mohdaman.eatx.Interface.ItemClickListener;
import com.mohdaman.eatx.R;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtMenuName;
    public ImageView imageView;
    private ItemClickListener itemClickListener;

    public MenuViewHolder( View itemView) {
        super(itemView);
        txtMenuName= (TextView)itemView.findViewById(R.id.menuname);
        imageView= (ImageView)itemView.findViewById(R.id.menuimage);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
