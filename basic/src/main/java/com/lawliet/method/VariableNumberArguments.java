package com.lawliet.method;

public class VariableNumberArguments {

    public static void main(String[] args) {
        print("1","2");
    }

    private static void print(String...a) {
        for (String s : a) {
            System.out.println(s);
        }
    }
}
