package com.Spring.took.Project50.InventoryManagement;

import java.io.Serializable;

public class Item implements Comparable<Item> , Serializable {
    private static final long serialVersionUID = 1L;
    private String item_id;
    private String item_name;
    private String category;
    private String quantity;

    public Item(String item_id, String item_name, String category, String quantity) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.category = category;
        this.quantity = quantity;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "🆔 " + item_id +
                " | 📦 Name: " + item_name +
                " | 📂 Category: " + category +
                " | 🔢 Quantity: " + quantity;
    }



    @Override
    public int compareTo(Item o) {
        return this.getItem_name().compareTo(o.getItem_name());
    }
}
