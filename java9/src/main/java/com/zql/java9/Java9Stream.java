package com.zql.java9;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java9Stream {
    public static void main(String[] args) {
//        Stream.of("a","b","c","","d","e").takeWhile(s -> !s.isEmpty()).forEach(System.out::print);

//        Stream.of("a", "b", "c", "", "d", "e").dropWhile(s -> s.isEmpty()).forEach(System.out::print);

//        IntStream.iterate(1,x -> x < 10,x -> x + 2).forEach(System.out::print);

        User user = null;
        Stream.ofNullable(user).forEach(user1 -> System.out.println(user1.getName()));
    }
}
