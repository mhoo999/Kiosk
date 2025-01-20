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

    // 장바구니에 담긴 아이템들의 합계를 반환
    public double getTotalPrice() {
        double totalPrice = 0;

        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }

        return totalPrice;
    }
}
