package com.zql.ringqueue;

/**
 * 自定义环形队列
 * @author dell
 */
public class RingQueue<E> {

    /**
     * 环形队列的大小
     */
    private int size;

    /**
     * 当前节点
     */
    private Node<E> node;

    /**
     * 第一个节点
     */
    private Node<E> first;

    /**
     * 最后一个节点
     */
    private Node<E> last;

    /**
     * 加入队列
     * @param e 要加入的元素
     * @return 加入结果
     */
    public boolean add(E e) {
        final Node<E> oldLast = last;
        final Node<E> newNode = new Node<>(e, oldLast, first);
        last = newNode;

        if (node == null) {
            node = newNode;
        }
        if (oldLast == null) {
            first = newNode;
            first.prev = first;
        } else {
            oldLast.next = newNode;
            first.prev = oldLast.next;
        }
        size++;
        return true;
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
