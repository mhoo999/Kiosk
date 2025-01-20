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

    public String getMenu() {
        return name + " | W " + price + " | " + description;
    }

    public Menu.Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

}
