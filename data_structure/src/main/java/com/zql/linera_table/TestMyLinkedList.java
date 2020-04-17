package com.zql.linera_table;

public class TestMyLinkedList {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(2);
        list.addLast(4);
        list.addLast(6);
        list.getData();
        list.getDataReverse(list.getHead());
    }
}
