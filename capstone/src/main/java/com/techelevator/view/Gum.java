package com.techelevator.view;

public class Gum extends Item{
    public static final String TYPE="Gum";
    public Gum(double price, int stock, String itemKey, String itemName){
        super(price, stock, itemKey, itemName);
    }
    public String getMessage(){
        return "Chew Chew, Yum!";
    }
}
