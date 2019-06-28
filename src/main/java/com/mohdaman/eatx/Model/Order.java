package com.mohdaman.eatx.Model;

public class Order {
    private String ProductId;
    private String ProductName;
    private String Quantity;
    private String Price;
    public  static String DBPhone;
    public  static String DBName;
    public Order(){

    }

    public Order(String productId, String productName, String quantity, String price, String DBPhone, String DBName) {
        ProductId = productId;
        ProductName = productName;
        Quantity = quantity;
        Price = price;
        this.DBPhone = DBPhone;
        this.DBName = DBName;
    }

    public Order(String foodId, String name, String number, String price) {
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDBPhone() {
        return DBPhone;
    }

    public void setDBPhone(String DBPhone) {
        this.DBPhone = DBPhone;
    }

    public String getDBName() {
        return DBName;
    }

    public void setDBName(String DBName) {
        this.DBName = DBName;
    }
}
