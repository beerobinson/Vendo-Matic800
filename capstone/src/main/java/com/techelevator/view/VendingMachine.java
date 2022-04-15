package com.techelevator.view;

import java.io.File;
import java.util.*;

public class VendingMachine extends Payment{
    Map<String,Item> itemInventory = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    double moneyInserted = 0.0;
    public VendingMachine(){
        File vend=new File("capstone/vendingmachine.csv");
        try(Scanner dataInput = new Scanner(vend)){
            while(dataInput.hasNextLine()){
                String lineOfInput = dataInput.nextLine();
                String[] arr = lineOfInput.split("\\|");
                if(arr[3].equalsIgnoreCase("Candy")){
                    Candy candy = new Candy(Double.parseDouble(arr[2]),5,arr[0],arr[1]) ;
                    this.itemInventory.put(arr[0],candy);
                }else if(arr[3].equalsIgnoreCase("Gum")){
                    Gum gum = new Gum(Double.parseDouble(arr[2]),5,arr[0],arr[1]) ;
                    this.itemInventory.put(arr[0],gum);
                }else if(arr[3].equalsIgnoreCase("Chip")){
                    Chip chip = new Chip(Double.parseDouble(arr[2]),5,arr[0],arr[1]) ;
                    this.itemInventory.put(arr[0],chip);
                }else if(arr[3].equalsIgnoreCase("Drink")){
                    Drink drink = new Drink(Double.parseDouble(arr[2]),5,arr[0],arr[1]) ;
                    this.itemInventory.put(arr[0],drink);
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void DisplayItems(){
       try {
           for (Map.Entry<String,Item> item : itemInventory.entrySet()) {
               item.getValue().DisplayItem();
           }
       }catch (Exception e){
           System.err.println(e.getMessage());
       }
    }
    public void DispenseItem(){
//        need to implement audit and test cases
        this.DisplayItems();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Item Key:");
        String DesiredItem = sc.nextLine();
        if(itemInventory.containsKey(DesiredItem)) {
            if (itemInventory.get(DesiredItem).getStock() > 0) {
                itemInventory.get(DesiredItem).setStock(itemInventory.get(DesiredItem).getStock() - 1);
                System.out.println(itemInventory.get(DesiredItem).getItemName() + " $" + itemInventory.get(DesiredItem).getPrice() + " " + itemInventory.get(DesiredItem).getMessage());
            } else {
                System.out.println("That Item is out of stock, make another selection.");
            }
        }else {
            System.out.println("That item key does not exist. Try again.");
        }
    }
}
