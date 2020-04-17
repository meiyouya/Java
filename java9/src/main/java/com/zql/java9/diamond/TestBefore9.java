package com.zql.java9.diamond;

public class TestBefore9 {
    public static void main(String[] args) {
//        Handler<Object> handler = new Handler<Object>(1) {    // Java9之前<>中必须有Object
        Handler<Object> handler = new Handler<Object>(1) {
            @Override
            void handler() {
                System.out.println(content);
            }
        };
        handler.handler();  // 输出1

//        Handler<Integer> handler2 = new Handler<Integer>(2) {     // Java9之前<>中必须有Integer
        Handler<Integer> handler2 = new Handler<Integer>(2) {
            @Override
            void handler() {
                System.out.println(content);
            }
        };
        handler2.handler(); //  输出2

//        Handler<String> handler3 = new Handler<String>("test") {      // Java9之前<>中必须有String
        Handler<String> handler3 = new Handler<String>("test") {
            @Override
            void handler() {
                System.out.println(content);
            }
        };
        handler3.handler();     // 输出 test
    }
}
