package com.mrlonewolfer.example54;

public class InventoryBean {
    int itemId,itemqty;
    String itemName;
    double itemPrice;

    public InventoryBean(int itemId, int itemqty, String itemName, double itemPrice) {
        this.itemId = itemId;
        this.itemqty = itemqty;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemqty() {
        return itemqty;
    }

    public void setItemqty(int itemqty) {
        this.itemqty = itemqty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
