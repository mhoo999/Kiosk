package com.example;

import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    ShoppingBasket shoppingBasket = new ShoppingBasket();
    OrderManager orderManager = new OrderManager(this);

    public void start() {
        // 유효한 입력을 처리하기 위한 boolean value
        boolean validInput = false;
        while (!validInput) {
            // 메인 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            menu.getCategory();
            System.out.println("0. exit");

            if (!shoppingBasket.isEmpty()) {
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders     | Check the shopping basket and place an order.");
                System.out.println("5. Cancel     | Clear the shopping basket.");
            }

            // 사용자 입력 처리
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        exit();
                        break;
                    case 1:
                        showBurgers();
                        validInput = true;
                        break;
                    case 4:
                        orderManager.orderMenu(shoppingBasket);
                        validInput = true;
                        break;
                    case 5:
                        shoppingBasket.removeAllItems();
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a number between 0 and 5.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 0 and 5.");
                scanner.nextLine();
            }
        }
    }

    private void showBurgers() {
        // 유효한 입력을 처리하기 위한 boolean value
        boolean validInput = false;
        while (!validInput) {
            // 버거 메뉴 출력
            System.out.println("[ SHAKESHACK NENU ]");
            menu.getMenu();
            System.out.println("0. back");

            // 사용자 입력 처리
            try {
                int choice = scanner.nextInt();
                chooseBurger(choice);
                validInput = true;
            } catch (Exception e) {
                int arraySize = menu.getArraySize();
                System.out.println("Invalid input. Please enter a number between 0 and " + arraySize + ".");
                scanner.nextLine();
            }
        }
    }

    private void chooseBurger(int inChoice) {
        if (inChoice == 0) {
            start();
            return;
        }

        int menuCount = menu.getArraySize();
        if (inChoice < 1 || inChoice > menuCount) {
            throw new IllegalArgumentException("Invalid input. Please enter a number between 0 and " + menuCount + ".");
        }

        // 선택한 메뉴 임시 저장
        MenuItem selected = menu.getMenu(inChoice - 1);

        // 유효한 입력을 처리하기 위한 boolean value
        boolean validInput = false;
        while (!validInput)
        {
            System.out.println("Do you want to add the item?");
            System.out.println("1. Yes     2. No");
            // 사용자 입력 처리
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // 선택한 메뉴를 장바구니에 추가
                        shoppingBasket.addItem(selected);
                        validInput = true;
                        break;
                    case 2:
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid input. Please enter a number between 1 and 2.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 2.");
                scanner.nextLine();
            }
        }

        // 시작 화면으로 전환
        start();
    }

    private void exit() {
        System.out.println("Closing the program.");
        System.exit(0);
    }
}
