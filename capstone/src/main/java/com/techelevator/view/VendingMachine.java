package com.techelevator.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachine extends Payment{
    List<Item> itemInventory = new ArrayList<>();
    double moneyInserted = 0.0;
    public VendingMachine(){
        File vend=new File("capstone/vendingmachine.csv");
        try(Scanner dataInput = new Scanner(vend)){
            while(dataInput.hasNextLine()){
                String lineOfInput = dataInput.nextLine();
                String[] arr = lineOfInput.split("\\|");
                if(arr[3].equalsIgnoreCase("Candy")){
                    Candy candy = new Candy(Double.parseDouble(arr[2]),5,arr[0],arr[1]) ;
                    this.itemInventory.add(candy);
                }else if(arr[3].equalsIgnoreCase("Gum")){
                    Gum gum = new Gum(Double.parseDouble(arr[2]),5,arr[0],arr[1]) ;
                    this.itemInventory.add(gum);
                }else if(arr[3].equalsIgnoreCase("Chip")){
                    Chip chip = new Chip(Double.parseDouble(arr[2]),5,arr[0],arr[1]) ;
                    this.itemInventory.add(chip);
                }else if(arr[3].equalsIgnoreCase("Drink")){
                    Drink drink = new Drink(Double.parseDouble(arr[2]),5,arr[0],arr[1]) ;
                    this.itemInventory.add(drink);
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void DisplayItems(){
       try {
           for (Item item : itemInventory) {
               item.DisplayItem();
           }
       }catch (Exception e){
           System.err.println(e.getMessage());
       }
    }
    public void DispenseItem(){
        this.DisplayItems();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Item Key:");
        String DesiredItem = sc.nextLine();
        for(Item itemK : itemInventory){
            if(itemK.itemKey.equalsIgnoreCase(DesiredItem)){
                if(itemK.getStock()>0){
                    itemK.setStock(itemK.getStock()-1);
                    System.out.println(itemK.getItemName()+" $"+itemK.getPrice()+" ");
                }
            }
        }

    }
}
