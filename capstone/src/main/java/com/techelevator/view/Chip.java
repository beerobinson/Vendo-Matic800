package com.techelevator.view;

public class Chip extends Item{
    public static final String TYPE="Chip";
    public Chip(double price, int stock, String itemKey, String itemName){
        super(price, stock, itemKey, itemName);
    }
   public String getMessage(){
        return "Crunch Crunch, Yum!";
   }
}
