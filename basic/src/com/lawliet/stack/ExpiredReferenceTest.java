package com.lawliet.stack;

/**
 * @author lawliet.L
 */
public class ExpiredReferenceTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("1");
        System.out.println(stack.pop());
        // stack中索引0出的数据按照道理应该是已经被移除了
        // 访问时抛出NPE才是合理的
        // 但是如果在stack列中没有对这种过期的引用进行清除
        // 在别的地方就可以再次访问到，从而造成某些不可预知的错误
        System.out.println(stack.getByIndex(0));
    }
}
