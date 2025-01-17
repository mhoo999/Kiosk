package com.example;

import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();

    public void start() {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("[ MAIN MENU ]");
            menu.getCategory();
            System.out.println("0. exit    | exit");
            try {
                int choice = scanner.nextInt();
                if (choice == 0) { exit(); }
                showMenu();
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                int arraySize = menu.getArraySize();
                System.out.println("Invalid input. Please enter a number between 0 and " + arraySize + ".");
                scanner.nextLine();
            }
        }
    }

    private void showMenu() {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("[ SHAKESHACK NENU ]");
            menu.getMenu();
            System.out.println("0. exit    | exit");
            try {
                int choice = scanner.nextInt();
                itemChoice(choice);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                int arraySize = menu.getArraySize();
                System.out.println("Invalid input. Please enter a number between 0 and " + arraySize + ".");
                scanner.nextLine();
            }
        }
    }

    private void itemChoice(int choice) {
        if (choice == 0) {
            exit();
        }

        int menuCount = menu.getArraySize();
        if (choice < 1 || choice > menuCount + 1) {
            throw new IllegalArgumentException("Invalid input. Please enter a number between 0 and " + menuCount + ".");
        }

        menu.getMenu(choice - 1);
        start();
    }

    private void exit() {
        System.out.println("Closing the program.");
        System.exit(0);
    }
}
