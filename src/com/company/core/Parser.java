package com.company.core;

import com.company.model.Item;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parser {

    public static List<Item> parse(String text) {
        if(text == null){
            throw new InvalidParameterException("text should not be NULL");
        }
        List list = new ArrayList<>();
        parseRec(text, 0, list);
        return list;
    }

    public static List<Item> sortedParse(String text) {
        if(text == null){
            throw new InvalidParameterException("text should not be NULL");
        }
        List<Item> list = parse(text);
        sort(list);
        return list;
    }

    private static int parseRec(String text, int currentIndex, List list) {
        if (currentIndex >= text.length()) {
            return text.length();
        }
        boolean startedWord = false;
        int startingIndex = currentIndex;

        for (int i = currentIndex; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar == '(') {
                if (startedWord) {
                    String currentWord = text.substring(startingIndex, i);
                    Item newItem = new Item(currentWord);
                    list.add(newItem);
                    i = parseRec(text, i + 1, newItem.getList());
                }
                startedWord = false;
            } else if (currentChar == ')') {
                if (startedWord) {
                    String currentWord = text.substring(startingIndex, i);
                    list.add(new Item(currentWord));
                }
                return i + 1;
            } else if (Character.isLetter(currentChar)) {
                if (!startedWord) {
                    startedWord = true;
                    startingIndex = i;
                }
            } else if (currentChar == ',') {
                if (startedWord) {
                    String currentWord = text.substring(startingIndex, i);
                    list.add(new Item(currentWord));
                }
                startedWord = false;
            }
        }
        return text.length();
    }

    private static void sort(List<Item> list) {
        list.sort(Comparator.comparing(Item::getValue));
        for (Item item : list) {
            sort(item.getList());
        }
    }
}
