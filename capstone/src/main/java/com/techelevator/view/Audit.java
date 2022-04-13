package com.techelevator.view;

import java.io.File;
import java.io.PrintWriter;

public class Audit {
    public Record(Item item){

    }
    public Record(String transaction, double amount){
        File datafile = new File("Log.txt");
        try(PrintWriter dataOutput = new PrintWriter(datafile)){

        }
    }
}
