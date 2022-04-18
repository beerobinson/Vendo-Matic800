package com.techelevator.view;

public class Chip extends Item{
    public static final String TYPE="Chip";
    public Chip(double price, String itemKey, String itemName){
        super(price, itemKey, itemName);
    }
   public String getMessage(){
        return "Crunch Crunch, Yum!";
   }
}
