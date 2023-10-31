package com.example.geektrust;

import com.example.geektrust.controller.GlobalController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final GlobalController globalController = new GlobalController();

    public static void main(String[] args) {
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                globalController.route(line);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }
    }
}
