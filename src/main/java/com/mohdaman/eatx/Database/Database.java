package com.mohdaman.eatx.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.mohdaman.eatx.Model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME="AmanDB.db";
    private static final int DB_VER=1;
    public Database(Context context){
        super(context,DB_NAME,null,DB_VER);
    }
public List<Order> getCarts()
{
    SQLiteDatabase db = getReadableDatabase();
    SQLiteQueryBuilder qb=new SQLiteQueryBuilder();
    String[] sqlSelect={"ProductId","ProductName","Quantity","Price","DBPhone","DBName"};
    String sqlTable ="OrderDetail";
    qb.setTables(sqlTable);
    Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);
    final List<Order> result=new ArrayList<>();
    if(c.moveToFirst())
    {
        do{
            result.add(new Order(c.getString(c.getColumnIndex("ProductId")),
                    c.getString(c.getColumnIndex("ProductName")),
                    c.getString(c.getColumnIndex("Quantity")),
                    c.getString(c.getColumnIndex("Price")),
                    c.getString(c.getColumnIndex("DBPhone")),
                    c.getString(c.getColumnIndex("DBName"))
            ));
        }while(c.moveToNext());
    }
    return result;
}

public void addToCart(Order order)

{
    SQLiteDatabase db=getReadableDatabase();
    String query=String.format("INSERT INTO OrderDetail(ProductId,ProductName,Quantity,Price,DBPhone,DBName) VALUES('%s','%s','%s','%s','%s','%s')",
            order.getProductId(),
            order.getProductName(),
            order.getQuantity(),
            order.getPrice(),
            order.getDBPhone(),
            order.getDBName());
    db.execSQL(query);
}
    public void cleanCart()
    {
        SQLiteDatabase db=getReadableDatabase();
        String query=String.format("DELETE FROM OrderDetail");
        db.execSQL(query);
    }

}
