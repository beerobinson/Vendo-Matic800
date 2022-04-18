package com.techelevator.view;



public class Candy extends Item{



    public static final String TYPE="Candy";



    public Candy( double price, String itemKey, String itemName ){

        super( price, itemKey, itemName );

    }



    public String getMessage(){

        return "Munch Munch, Yum!";

    }

    
}
