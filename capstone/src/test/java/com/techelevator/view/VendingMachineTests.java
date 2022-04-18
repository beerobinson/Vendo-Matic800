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
    public void itemInventoryContainsAllItems(){
        int actualMapSize = vend.itemInventory.size();
        int expectedMapSize = 16;
        Assert.assertEquals(expectedMapSize,actualMapSize);
    }

}
