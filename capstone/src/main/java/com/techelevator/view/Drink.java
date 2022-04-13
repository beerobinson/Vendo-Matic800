package com.techelevator.view;

public class Drink extends Item{
    public static final String MESSAGE="Glug Glug, Yum!";
    public Drink(double price, int stock, String itemKey, String itemName){
        super(price, stock, itemKey, itemName);
    }
    public static final String TYPE="Drink";
}
