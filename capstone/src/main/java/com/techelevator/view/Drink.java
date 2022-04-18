package com.techelevator.view;

public class Drink extends Item{
    public static final String TYPE="Drink";
    public Drink(double price, String itemKey, String itemName){
        super(price, itemKey, itemName);
    }
    public String getMessage(){
        return "Glug Glug, Yum!";
    }
}
