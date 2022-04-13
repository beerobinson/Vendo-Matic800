package com.techelevator.view;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Audit {
    LocalDate date = LocalDate.now();
    LocalDateTime time = LocalDateTime.now();
//    public void Record(Item item){
//
//    }
    public void Record(String transaction, double amount){
        File datafile = new File("Log.txt");
        try(PrintWriter dataOutput = new PrintWriter(datafile)){
            dataOutput.println(date + " " + time + " " + transaction + " " + amount);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
