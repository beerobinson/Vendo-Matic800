package com.techelevator.view;

public class Chip extends Item{
    public static final String MESSAGE="Crunch Crunch, Yum!";
    public Chip(double price, int stock, String itemKey, String itemName){
        super(price, stock, itemKey, itemName);
    }
    public static final String TYPE="Chip";
}
