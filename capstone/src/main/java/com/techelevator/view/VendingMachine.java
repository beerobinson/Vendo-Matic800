package com.techelevator.view;

import java.io.File;
import java.text.NumberFormat;
import java.util.*;

public class VendingMachine extends Payment{


    Map<String,Item> itemInventory = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);



    public VendingMachine(String pathName){


        File vend = new File(pathName);


        try(Scanner dataInput = new Scanner(vend)){

            while(dataInput.hasNextLine()){

                //A line of input is itemKey|itemName|price|type

                String lineOfInput = dataInput.nextLine();
                String[] arr = lineOfInput.split("\\|");

                if(arr[3].equalsIgnoreCase("Candy")){
                    Candy candy = new Candy( Double.parseDouble(arr[2]) , arr[0] , arr[1] ) ;
                    this.itemInventory.put( arr[0] , candy );


                }else if(arr[3].equalsIgnoreCase("Gum")){
                    Gum gum = new Gum(Double.parseDouble( arr[2]) , arr[0] , arr[1] ) ;
                    this.itemInventory.put( arr[0] , gum );


                }else if(arr[3].equalsIgnoreCase("Chip")){
                    Chip chip = new Chip( Double.parseDouble(arr[2]) , arr[0] , arr[1] ) ;
                    this.itemInventory.put( arr[0] , chip );


                }else if(arr[3].equalsIgnoreCase("Drink")){
                    Drink drink = new Drink( Double.parseDouble(arr[2]) , arr[0] ,arr[1] ) ;
                    this.itemInventory.put( arr[0] , drink );
                }
            }


        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }




    public void Purchase(){

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Scanner userInput = new Scanner(System.in);

        System.out.println( "\n (1) Feed Money \n (2) Select Product \n (3) Finish Transaction \n \n Current Money Provided: " + formatter.format( this.getUserMoney() ) );

        System.out.println("Please choose an option >>> ");

        int choice = userInput.nextInt();


        if (choice == 1){
            this.Insert();
            this.Purchase();

        }else if (choice == 2){
            this.DispenseItem();
            this.Purchase();

        }else if (choice == 3){
            this.ReturnMoney();
            return;

        }else{
            System.out.println("That is not a valid choice.");
        }
    }




    public void DisplayItems(){

       try {

           for ( Map.Entry<String,Item> item : itemInventory.entrySet() ) {
               item.getValue().DisplayItem();
           }
       } catch ( Exception e ){
           System.err.println(e.getMessage());
       }

    }




    public void DispenseItem(){

        this.DisplayItems();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Item Key:");
        String desiredItemKey = sc.nextLine();


        if( itemInventory.containsKey( desiredItemKey ) ) {

            if ( itemInventory.get( desiredItemKey ).getStock() > 0 ) {

                itemInventory.get(desiredItemKey).pullItem();

                System.out.println(itemInventory.get(desiredItemKey).getItemName() + " $" + itemInventory.get(desiredItemKey).getPrice() + " " + itemInventory.get(desiredItemKey).getMessage());

                double previousAmount = this.getUserMoney();
                Withdraw( itemInventory.get(desiredItemKey) );

                Record((itemInventory.get( desiredItemKey ).itemName + " " + desiredItemKey), previousAmount, this.getUserMoney() );
           
           
            } else {
                System.out.println("That Item is out of stock, make another selection.");


            }
        }else {
            System.out.println("That item key does not exist. Try again.");
        }
    }
}
