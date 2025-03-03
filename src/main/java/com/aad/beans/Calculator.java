package com.aad.beans;

public class Calculator {
    public int add(int a, int b) {
        int sum = 0;

        System.out.println("in add()");
        sum = a + b;

        return sum;
    }

    public int multiply(int a, int b) {
        int mul = 0;

        System.out.println("in multiply()");
        mul = a * b;
        return mul;
    }
}
