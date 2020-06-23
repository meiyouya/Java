package com.lawliet.string;

/**
 * @author lawliet.L
 */
public class InternTest {

    public static void main(String[] args) {
        // 创建String对象时，可以不适用new操作符，使用new操作符可以强制在堆中创建一个对象
        // "a"会先被在字符串常量池中创建，然后由于使用了new，会在堆中再创建一个"a"，s1指向堆中的"a"
        String s1 = new String("a");
        // 调用intern方法时，由于"a"已经在堆中存在，所以会尝试把"a"加入到常量池中，但是常量池中已存在了
        // 而且存在的也不是堆中已存在的"a"的引用，是独立存在的，所以intern不会执行任何操作
        s1.intern();
        // 由于常量池中已存在"a"，s2会直接指向常量池中的"a"
        String s2 = "a";
        // 通过以上分析，很明显，s1和s2指向的都不是通同一个对象，自然下面的语句是false
        // 而且，实际上  s1.intern()方法是没有进行任何操作的，所以不执行s1.intern()方法，结果依然是false
        // 但是如果 String s1 = "a"，不使用new，那么结果就是true了，因为不new的话，会直接在常量池中创建一个"a"，然后s1指向它
        System.out.println(s1 == s2);
        // 两个要new的"a"在常量池中已经存在了，所以这里会直接在堆中创建一个"aa"，然后s3指向它
        String s3 = new String("a") + new String("a");
        // 执行intern方法时，发现池中没有"aa"，但是堆中有，于是就会把堆中这个对象的引用加入到字符串常量池中
        // 池中就存在可以访问对中"aa"的引用
        s3.intern();
        // 池中已存在"aa"，所以s4指向池中的"aa"
        String s4 = "aa";
        // 池中存放的实际上是堆中的引用，指向的是同一个对象，所以下面的表达式输出true
        // 如果不执行 s3.intern()方法，常量池中就不存在堆中对象的引用
        // 运行String s4 = "aa"时，池中没有"aa"，会自行创建一个并指向它
        // 那么s3和s4指向的就不是一个对象，输出结果就会变成false
        System.out.println(s3 == s4);
    }
}
