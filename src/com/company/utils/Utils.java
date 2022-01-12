package com.company.utils;

import com.company.model.Item;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static void printItemsHierarchy(List<Item> list) {
        if (list == null) {
            throw new InvalidParameterException("list should not be NULL");
        }
        printRec(list, 1);
    }

    private static void printRec(List<Item> list, int depth) {
        for (Item item : list) {
            System.out.println(String.join("", Collections.nCopies(depth - 1, "-")) + item.getValue());
            printRec(item.getList(), depth + 1);
        }
    }
}
