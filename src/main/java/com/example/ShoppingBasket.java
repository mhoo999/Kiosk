package com.example;

import java.util.ArrayList;

public class ShoppingBasket {
    ArrayList<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeAllItems() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void getAllItems() {
        for (MenuItem item : items) {
            System.out.println(item.getMenu());
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;

        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }

        return totalPrice;
    }
}
