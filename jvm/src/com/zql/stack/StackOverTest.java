package com.zql.stack;

public class StackOverTest {

    private static int index = 1;

    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        final StackOverTest stackOverTest = new StackOverTest();
        try {
            stackOverTest.call();
        }catch (Throwable e) {
            System.out.println("stack deep : " + index);
            e.printStackTrace();
        }
    }
}
