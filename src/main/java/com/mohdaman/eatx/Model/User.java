package com.mohdaman.eatx.Model;

public class User {
    private String name;
    private String pnr;
    private String phone;
    private String dbname="";
    private String dbphone="";
    public User() {
    }

    public User(String name, String pnr, String phone,String dbname,String dbphone) {
        this.name = name;
        this.pnr = pnr;
        this.phone = phone;
        this.dbname=dbname;
        this.dbphone=dbphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}