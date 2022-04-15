package com.techelevator.view;

public class Drink extends Item{
    public static final String TYPE="Drink";
    public Drink(double price, int stock, String itemKey, String itemName){
        super(price, stock, itemKey, itemName);
    }
    public String getMessage(){
        return "Glug Glug, Yum!";
    }
}
