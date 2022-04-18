package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;


public class VendingMachineTests {

    VendingMachine vend = new VendingMachine("src/test/resources/vendingmachine.csv");



    @Test
    public void pullItemTakes1ItemTest(){

        vend.itemInventory.get("B4").pullItem();
        int expectedStock = 4;
        Assert.assertEquals(expectedStock,vend.itemInventory.get("B4").stock);

    }

    @Test
    public void itemInventoryContainsAllItemsTest(){

        int actualMapSize = vend.itemInventory.size();
        int expectedMapSize = 16;
        Assert.assertEquals(expectedMapSize,actualMapSize);
        
    }

//    @Test
//    public void changeTest(){
//        vend.setUserMoney(4.05);
//        vend.ReturnMoney();
//        int expectedQuarters = 16;
//        int expectedNickels = 1;
//        int expectedDimes = 0;
//        Assert.assertEquals(expectedQuarters,);
//    }
}
