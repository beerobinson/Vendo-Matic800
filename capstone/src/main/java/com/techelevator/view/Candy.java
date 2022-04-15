package com.techelevator.view;

public class Candy extends Item{
    public static final String TYPE="Candy";
    public Candy(double price, int stock, String itemKey, String itemName){
        super(price, stock, itemKey, itemName);
    }
    public String getMessage(){
        return "Munch Munch, Yum!";
    }
}
