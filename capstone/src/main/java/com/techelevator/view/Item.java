package com.techelevator.view;

import java.text.NumberFormat;

public abstract class Item {


    String itemName;
    String itemKey;
    double price;
    int stock;





    public abstract String getMessage();



    public String getItemName() {
        return itemName;
    }




    public String getItemKey() {
        return itemKey;
    }




    public double getPrice() {
        return price;
    }



    public int getStock() {
        return stock;
    }



    public void pullItem() {

        stock--;
        
    }



    public Item ( double price , String itemKey , String itemName ){

        this.price=price;
        this.stock=5;
        this.itemKey=itemKey;
        this.itemName=itemName;

    }

    public void DisplayItem(){

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println( this.getItemKey() + " " + this.getItemName() + " " + formatter.format(this.getPrice()) + " " + this.getStock() );

    }




}
