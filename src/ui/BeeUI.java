package ui;

import business.BeeHive;
import entity.Bee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BeeUI {
    private static int readSingleChar() throws IOException {
        // Try to set raw mode (works on Unix/Linux/Mac)
        try {
            String[] cmd = {"/bin/sh", "-c", "stty raw -echo < /dev/tty"};
            Runtime.getRuntime().exec(cmd).waitFor();
        } catch (Exception e) {
            // If stty fails, fall back to regular input
        }
        
        int ch = System.in.read();
        
        // Restore normal mode
        try {
            String[] cmd = {"/bin/sh", "-c", "stty cooked echo < /dev/tty"};
            Runtime.getRuntime().exec(cmd).waitFor();
        } catch (Exception e) {
            // Ignore restoration errors
        }
        
        return ch;
    }
    
    public static void main(String[] args) {
        BeeHive beeHive = null;
        boolean keepRunning = true;
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (keepRunning) {
            System.out.println("=================BeeHive=================");
            System.out.println("\t1 - Create Bee Hive");
            System.out.println("\t2 - Attack Bee Hive");
            System.out.println("\t3 - Exit");
            System.out.println("===========================================");
        
        System.out.print("Enter your choice: ");
        try {
            choice = readSingleChar() - '0';
            System.out.println(); // Add newline after input
        } catch (IOException e) {
            System.out.println("Error reading input");
            continue;
        }

            ArrayList<Bee> bees;
            if (choice < 1 || choice > 3) {
                continue;
            }
            switch (choice) {
                case 1 -> {
                    beeHive = new BeeHive();
                    beeHive.initBeeHive();
                    bees = beeHive.getBees();
                    System.out.println("Bee Hive Initialized");
                    for (Bee bee : bees) {
                        System.out.println(bee);
                    }
                }
                case 2 -> {
                    if (beeHive == null) {
                        System.out.println("Please create a bee hive first!");
                        break;
                    }
                    bees = beeHive.getBees();
                    System.out.println("Attacking the bee hive...");
                    for (Bee bee : bees) {
                        bee.damage();
                        bee.updateStatus();
                    }
                    System.out.println("After attack:");
                    for (Bee bee : bees) {
                        System.out.println(bee);
                    }
                }
                case 3 -> keepRunning = false;
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}