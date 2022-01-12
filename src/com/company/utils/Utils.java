package com.company.utils;

import com.company.model.Item;

import java.util.Collections;
import java.util.List;

public class Utils {

    public static void printItemsHierarchy(List<Item> list) {
        if (list != null || list.size() != 0) {
            printRec(list, 1);
        } else {
            System.out.println("### List is empty ###");
        }
    }

    private static void printRec(List<Item> list, int depth) {
        for (Item item : list) {
            System.out.println(String.join("", Collections.nCopies(depth - 1, "-")) + item.getValue());
            printRec(item.getList(), depth + 1);
        }
    }
}
