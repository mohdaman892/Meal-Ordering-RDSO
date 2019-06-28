package com.mohdaman.eatx.Model;

public class Food {
    private String name,menuId,price,image,discount,description;

    public Food() {
    }

    public Food(String name, String menuId, String price, String image, String discount, String description) {
        this.name = name;
        this.menuId = menuId;
        this.price = price;
        this.image = image;
        this.discount = discount;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}