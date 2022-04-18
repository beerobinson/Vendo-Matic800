package com.techelevator.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("MM/dd/yyyy KK:mm:ss a");
    public void Record(String transaction, double currentAmount, double newAmount){
        File datafile = new File("Log.txt");
        try(PrintWriter dataOutput = new PrintWriter(new FileOutputStream(datafile,true))){
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            dataOutput.println(dateformat.format(date) + " " + transaction + " " + formatter.format(currentAmount) + " " + formatter.format(newAmount));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
