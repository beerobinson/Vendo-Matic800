package com.techelevator.view;


public class Gum extends Item{

    public static final String TYPE="Gum";

    

    public Gum( double price, String itemKey, String itemName ){

        super( price, itemKey, itemName );

    }


    public String getMessage(){

        return "Chew Chew, Yum!";
        
    }


}
