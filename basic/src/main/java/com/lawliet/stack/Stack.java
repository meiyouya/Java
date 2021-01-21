package com.lawliet.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author lawliet.L
 */
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_ENSURE_FACTOR = 0.75f;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        // size会比实际索引大1，所以先执行--size
        Object result = elements[--size];
        // 消除过期引用，因为elements[size]已经是被pop，此引用可能很长一段时间都不会再有其他地方使用，
        // 但是由于引用存在，对应的内存空间就会被保留，所以通过手动置为null使GC可以快速回收该引用
        elements[size] = null;
        return result;
    }

    public Object getByIndex(int index) {
        return elements[index];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, (int) ((1 + DEFAULT_ENSURE_FACTOR) * size));
        }
    }
}
