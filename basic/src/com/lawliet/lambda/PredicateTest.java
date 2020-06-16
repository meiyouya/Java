package com.lawliet.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author dell
 */
public class PredicateTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        printNum(list, n -> true);
        printNum(list, n -> n % 2 == 0);
        printNum(list, n -> n > 4);
    }

    private static void printNum(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer num : list) {
            if (predicate.test(num)) {
                System.out.println(num);
            }
        }
    }
}
