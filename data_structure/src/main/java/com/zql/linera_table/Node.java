package com.zql.linera_table;

/**
 * 节点类
 * 存放每个节点的数据及下一个节点的引用
 * @param <T>
 */
public class Node<T> {

    public T data;  // 存放当前节点的数据

    public Node<T> next = null;    // 在当前节点中存放指向下一节点的索引

    public Node(T data) {
        this.data = data;
    }
}
