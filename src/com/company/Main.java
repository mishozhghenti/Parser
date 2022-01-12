package com.company;

import com.company.core.Parser;
import com.company.model.Item;
import com.company.utils.Utils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String text = args[0];
        List<Item> list = Parser.parse(text);
        List<Item> sortedList = Parser.sortedParse(text);
        System.out.println("### Just Parsed ###");
        Utils.printItemsHierarchy(list);
        System.out.println("### Sorted ###");
        Utils.printItemsHierarchy(sortedList);
    }
}
