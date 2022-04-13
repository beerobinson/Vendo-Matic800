package com.techelevator.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachine {
    List<Item> stock = new ArrayList<>();
    double moneyInserted = 0.0;
    public VendingMachine(){
        File vend=new File("capstone/vendingmachine.csv");
        try(Scanner dataInput = new Scanner(vend)){
            while(dataInput.hasNextLine()){
                String lineOfInput = dataInput.nextLine();
                String[] arr = lineOfInput.split("|");
                if(arr[3].equalsIgnoreCase("Candy")){
                    this.stock.add(new Candy(Double.parseDouble(arr[2]),5,arr[0],arr[1])) ;
                }else if(arr[3].equalsIgnoreCase("Gum")){
                    this.stock.add(new Gum(Double.parseDouble(arr[2]),5,arr[0],arr[1])) ;
                }else if(arr[3].equalsIgnoreCase("Chip")){
                    this.stock.add(new Chip(Double.parseDouble(arr[2]),5,arr[0],arr[1])) ;
                }else if(arr[3].equalsIgnoreCase("Drink")){
                    this.stock.add(new Drink(Double.parseDouble(arr[2]),5,arr[0],arr[1])) ;
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void DisplayItems(){
       try {
           for (Item item : stock) {
               item.DisplayItem();
           }
       }catch ()
    }
}
