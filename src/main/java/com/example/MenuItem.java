package com.example;

public class MenuItem {
    public MenuItem(String inName, double inPrice, String inDescription, Menu.Category inCategory) {
        name = inName;
        price = inPrice;
        description = inDescription;
        category = inCategory;
    }

    final private String name;
    final private double price;
    final private String description;
    final private Menu.Category category;

    // 메뉴 출력 양식에 따라 아이템 정보를 반환
    public String getMenu() {
        return name + " | W " + price + " | " + description;
    }

    public double getPrice() {
        return price;
    }

}
