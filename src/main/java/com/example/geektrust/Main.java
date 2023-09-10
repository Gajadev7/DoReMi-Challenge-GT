package com.example.geektrust;

import com.example.geektrust.service.DoReMi;
import com.example.geektrust.service.Parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Sample code to read from file passed as command line argument
        IParser parser = new Parser();
        IDoReMi doReMi = new DoReMi();

        FrontEndApp frontEndApp = new FrontEndApp(doReMi, parser);

        try {
            // the file to be opened for reading

            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                frontEndApp.getInput(sc.nextLine());
               //Add your code here to process input commands
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }

    }
}
