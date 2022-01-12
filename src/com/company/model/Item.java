package com.company.model;

import java.util.ArrayList;

public class Item {
    private String value;
    private final ArrayList<Item> list = new ArrayList<>();

    public Item(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public ArrayList<Item> getList() {
        return list;
    }
}
