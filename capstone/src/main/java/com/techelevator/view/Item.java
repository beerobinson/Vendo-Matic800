package com.techelevator.view;

public abstract class Item {
    String message;
    String itemName;
    String itemKey;
    String type;
    double price;
    int stock;



    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMessage() {
        return message;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemKey() {
        return itemKey;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public Item (double price, int stock, String itemKey, String itemName){
        this.price=price;
        this.stock=stock;
        this.itemKey=itemKey;
        this.itemName=itemName;
    }

    public void DisplayItems(){
        System.out.println(this.getItemKey()+" "+ this.getItemName()+" $"+this.getPrice()+" "+this.getStock());
    }




}
