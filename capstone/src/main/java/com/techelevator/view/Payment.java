package com.techelevator.view;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public abstract class Payment extends Audit{


    
    private static final double QUARTER_VALUE = 0.25;
    private static final double DIME_VALUE = 0.10;
    private static final double NICKEL_VALUE = 0.05;
   
    private double userMoney = 0.0;

    NumberFormat formatter = NumberFormat.getCurrencyInstance();


    public double getUserMoney() {

        return userMoney;
    }



    public void Insert(){

        Scanner userInput = new Scanner(System.in);

        System.out.println("Insert Money Here:");
        int money = userInput.nextInt();

        if ( (money != 1) && (money != 2) && (money != 5) && (money != 10)){

            System.out.println("That is not valid tender.");
            return;

        }else{

            this.Record( "Feed Money",userMoney,( userMoney + money ) );
            userMoney = userMoney + money;

        }

    }



    public void Withdraw(Item item){


        if(userMoney - item.getPrice() < 0){

            System.out.println("You don't have enough money. :(");
            return;

        }else {

            this.Record( ( item.getItemName() + " " + item.getItemKey() ), userMoney, (userMoney - item.getPrice() ) );
            userMoney = userMoney - item.getPrice();

        }
    }



    public void ReturnMoney(){

        DecimalFormat rounder = new DecimalFormat(".##");
        rounder.setRoundingMode(RoundingMode.CEILING);

        double money = userMoney;
        int quarters = 0;
        int dimes = 0;
        int nickles = 0;

        while ( money  >  .05 ){

            if ( money >= QUARTER_VALUE ){

                quarters++;
                money = Double.parseDouble(rounder.format(money - QUARTER_VALUE));

            } else if ( money >= DIME_VALUE ){

                dimes++;
                money = Double.parseDouble(rounder.format(money - DIME_VALUE));

            } else if ( money >= NICKEL_VALUE ){

                nickles++;
                money = Double.parseDouble(rounder.format(money - NICKEL_VALUE));

            }


            formatter.format(money);
        }
        
        System.out.println("You receive:" + quarters + " quarters," + dimes + " dimes," + nickles + " nickles.");

        this.Record("Give Change:", userMoney, 0);
        
        userMoney = 0;
    }
}
