package com.example;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> menuList = new ArrayList<>();

    public enum Category {
        Burgers,
        Drinks,
        Desserts,
    }

    public Menu() {
        MenuItem menu1 = new MenuItem("ShackBurger", 6.9, "Cheeseburger topped with tomato, lettuce, and ShackSauce", Category.Burgers);
        MenuItem menu2 = new MenuItem("SmokeBurger", 8.9, "Cheeseburger topped with bacon, cherry peppers, and ShackSauce", Category.Burgers);
        MenuItem menu3 = new MenuItem("CheeseBurger", 6.9, "Cheeseburger with a potato bun, beef patty, and cheese", Category.Burgers);
        MenuItem menu4 = new MenuItem("HamBurger", 5.4, "Classic burger with a beef patty and vegetables", Category.Burgers);

        menuList.add(menu1);
        menuList.add(menu2);
        menuList.add(menu3);
        menuList.add(menu4);
    }

    public int getArraySize() {
        return menuList.size();
    }

    public void getMenu() {
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i+1) + ". " + menuList.get(i).getMenu());
        }
    }

    public MenuItem getMenu(int order) {
        System.out.println("Your choice: " + menuList.get(order).getMenu());
        return menuList.get(order);
    }

    public void getCategory() {
        for (int i = 0; i < Category.values().length; i++) {
            System.out.println((i+1) + ". " + Category.values()[i]);
        }
    }
}
