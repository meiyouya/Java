package com.zql.java9.cleaner;

public class Adult {

    public static void main(String[] args) {
        // 使用try-with-resource一定会调用对象的close方法
        try(Room r = new Room(7)) {
            System.out.println("exit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
