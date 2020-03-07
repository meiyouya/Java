package com.zql.method;

public class HannuoTower {

    private static final String LEFT = "A";

    private static final String MIDDLE = "B";

    private static final String RIGHT = "C";

    public static void main(String[] args) {
        doTower(3,LEFT,MIDDLE,RIGHT);
    }

    /**
     * @param diskNumber 要移动的盘的编号，最小的盘编号是1
     * @param from 从哪跟柱子上移动，即这个盘现在处于哪根柱子
     * @param target 移动到哪一个柱子
     */
    private static void doTower(int diskNumber,String from,String middle,String target) {
        if (diskNumber == 1) {  // 如果是最小的盘子，直接移动即可
            remove(diskNumber,from,target);
        } else {    // 如果不是最小的盘，就需要把它上面的盘移到中间盘去
            doTower(diskNumber - 1,from,target,middle);
            // 将其上面的盘移走后，就可以移动它
            remove(diskNumber,from,target);
            // 将其移走后，需要将之间移到中间的盘，放到目标盘上，即放在这块盘的上面
            doTower(diskNumber - 1,middle,from,target);
        }
    }

    private static void remove(int diskNumber,String source,String target) {
        System.out.println(diskNumber + "由" + source + "移动到" + target);
    }
}
