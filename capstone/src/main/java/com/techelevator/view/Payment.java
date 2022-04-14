package com.techelevator.view;

import java.util.Scanner;

public abstract class Payment extends Audit{
    private double userMoney = 0.0;

    public void Insert(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Insert Money Here:");
        int money = userInput.nextInt();
        if (money != 1 && money != 2 && money != 5 && money != 10){
            System.out.println("That is not valid tender.");
            return;
        }else{
            this.Record("Feed Money",userMoney,(userMoney+money));
            userMoney=userMoney+money;
        }
    }
    public void Withdraw(Item item){
        if(userMoney - item.getPrice() < 0){
            System.out.println("You don't have enough money. :(");
            return;
        }else {
            this.Record((item.getItemName() + " " + item.getItemKey()), userMoney, (userMoney - item.getPrice()));
            userMoney = userMoney - item.getPrice();
        }
    }
    public void ReturnMoney(){
        double money = userMoney;
        int quarters = 0;
        int dimes = 0;
        int nickles = 0;
        while (money != 0){
            while(money % 0.25 == 0){
                quarters++;
                money -= 0.25;
            }
            while(money % 0.10 == 0){
                dimes++;
                money -= 0.10;
            }
            while(money % 0.05 == 0){
                nickles++;
                money -= 0.05;
            }
        }
        System.out.println("You recieve:" + quarters + " quaters," + dimes + " dimes," + nickles + " nickles.");
        this.Record("Give Change:", userMoney, 0);
        userMoney = 0;
    }
}
