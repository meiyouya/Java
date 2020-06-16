package com.lawliet.lambda;

/**
 * @author dell
 */
public class MathOperationLambda {

    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation sub = (a, b) -> a - b;
        MathOperation mul = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;

        System.out.println(operate(10, 5, add));
        System.out.println(operate(10, 5, sub));
        System.out.println(operate(10, 5, mul));
        System.out.println(operate(10, 5, division));
    }

    public static int operate(int a, int b, MathOperation operation) {
        return operation.operation(a, b);
    }
}
