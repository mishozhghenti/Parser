package com.company.core;

import com.company.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

class ParserTest {

    @Test
    void TestSimpleParseMethod() {
        List<Item> list0 = Parser.parse("(a)");
        List<Item> list1 = Parser.parse("(a,b,c)");
        Assertions.assertEquals(list0.size(), 1);
        Assertions.assertEquals(list0.get(0).getValue(), "a");
        Assertions.assertEquals(list1.size(), 3);
        Assertions.assertEquals(list1.get(0).getValue(), "a");
        Assertions.assertEquals(list1.get(1).getValue(), "b");
        Assertions.assertEquals(list1.get(2).getValue(), "c");
    }

    @Test
    void TestParseMethodWithNestedString1() {
        List<Item> list = Parser.parse("(a(b(c)))");
        Assertions.assertEquals(list.size(), 1);
        Assertions.assertEquals(list.get(0).getList().size(), 1);
        Assertions.assertEquals(list.get(0).getList().get(0).getList().size(), 1);

        Assertions.assertEquals(list.get(0).getValue(), "a");
        Assertions.assertEquals(list.get(0).getList().get(0).getValue(), "b");
        Assertions.assertEquals(list.get(0).getList().get(0).getList().get(0).getValue(), "c");
    }

    @Test
    void TestParseMethodWithNestedString2() {
        List<Item> list = Parser.parse("(a(b(c,d,e), f), g, h,i)");
        Assertions.assertEquals(list.size(), 4);
        Assertions.assertEquals(list.get(0).getList().size(), 2);
        Assertions.assertEquals(list.get(0).getList().get(0).getList().size(), 3);

        Assertions.assertEquals(list.get(0).getValue(), "a");
        Assertions.assertEquals(list.get(1).getValue(), "g");
        Assertions.assertEquals(list.get(2).getValue(), "h");
        Assertions.assertEquals(list.get(3).getValue(), "i");

        Assertions.assertEquals(list.get(0).getList().get(0).getValue(), "b");
        Assertions.assertEquals(list.get(0).getList().get(1).getValue(), "f");

        Assertions.assertEquals(list.get(0).getList().get(0).getList().get(0).getValue(), "c");
        Assertions.assertEquals(list.get(0).getList().get(0).getList().get(1).getValue(), "d");
        Assertions.assertEquals(list.get(0).getList().get(0).getList().get(2).getValue(), "e");
    }

    @Test
    void TestParseMethodWithNullArgument() {
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            Parser.parse(null);
        });
    }

    @Test
    void TestSortedParseMethodWithNullArgument() {
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            Parser.sortedParse(null);
        });
    }

    @Test
    void sortedParse() {
        List<Item> list = Parser.sortedParse("(e, a(k, b),c)");
        Assertions.assertEquals(list.get(0).getValue(), "a");
        Assertions.assertEquals(list.get(0).getList().get(0).getValue(), "b");
        Assertions.assertEquals(list.get(0).getValue(), "a");
        Assertions.assertEquals(list.get(1).getValue(), "c");
        Assertions.assertEquals(list.get(2).getValue(), "e");
    }
}