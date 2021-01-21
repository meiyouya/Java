package com.lawliet.finalizer;

public class FinalizerTest {

    public static void main(String[] args) {
        Integer a = null;
        Integer b = 1;
        Integer c = 2;
        Integer d = 3;
        try {
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            b.toString();
            c.toString();
            d.toString();
            a.toString();
        }
    }
}
