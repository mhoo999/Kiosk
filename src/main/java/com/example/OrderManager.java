package com.example;

import java.util.Scanner;

public class OrderManager {
    private final Kiosk kiosk;

    public OrderManager(Kiosk kiosk) {
        this.kiosk = kiosk;
    }

    public void orderMenu(ShoppingBasket shoppingBasket) {
        System.out.println("Would you like to order as below?");
        System.out.println(" ");
        shoppingBasket.getAllItems();
        System.out.println(" ");
        System.out.println("[ Total ]");
        System.out.println(shoppingBasket.getTotalPrice());
        System.out.println(" ");

        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            System.out.println("1. Order     2. Menu");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        double discountAmount = discount();
                        System.out.println("Your order is complete. The price is " + (shoppingBasket.getTotalPrice() * (1.0 - discountAmount)));
                        validInput = true;
                        break;
                    case 2:
                        validInput = true;
                        kiosk.start();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 or 2.");
                scanner.nextLine();
            }
        }
    }

    private double discount() {
        double discountAmount = 0;

        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Please enter the discount information.");
            System.out.println("1. National Merit Recipient : 10%");
            System.out.println("2. Soldier : 5%");
            System.out.println("3. Student : 3%");
            System.out.println("4. Normal : 0%");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        validInput = true;
                        discountAmount = 0.1;
                        break;
                    case 2:
                        validInput = true;
                        discountAmount = 0.05;
                        break;
                    case 3:
                        validInput = true;
                        discountAmount = 0.03;
                        break;
                    case 4:
                        validInput = true;
                        discountAmount = 0.0;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.nextLine();
            }
        }

        return discountAmount;
    }
}
