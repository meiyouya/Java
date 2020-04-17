package com.zql.linera_table;

import java.util.List;

public class MyLinkedList<T> {

    private Node<T> head = null;   // 头结点

    private Node<T> last = null;   // 最后一个节点

    public boolean addLast(T t) {
        if (last == null) {
            head = new Node<>(t);
            last = head;
        } else {
            Node<T> l = last;
            Node<T> newNode = new Node<>(t);
            l.next = newNode;
            last = newNode;
        }
        return true;
    }

    /**
     * 顺序遍历链表
     */
    public void getData() {
        Node<T> current = head;
        while (current!=null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // 倒序遍历链表，因为单向链表没有指向前一个节点的属性，所以只能从头开始
    // 如果这个头的next的属性不是null，说明他不是最后一个，那么就去找最后一个
    public void getDataReverse(Node<T> head) {
        if (head != null) {
            getDataReverse(head.next);
            System.out.println(head.data);
        }
    }

    public Node<T> getHead() {
        return head;
    }

}
