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
     * 当前节点指针
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
            // 如果当前没有指向任何节点，那就指向最新的节点
            node = newNode;
        }
        if (oldLast == null) {
            // 如果之前的最后一个节点为null，说明环形队列中没有任何元素
            first = newNode;
            first.prev = last;
        } else {
            // 如果之前的最后一个节点不为null，那就
            oldLast.next = newNode;
            first.prev = oldLast.next;
        }
        size++;
        return true;
    }

    /**
     * 返回当前指向的元素，并把指针指向下一个元素
     * @return 当前元素
     */
    public E next() {
        if (node == null) {
            return null;
        }
        E item = node.item;
        node = node.next;
        return item;
    }

    /**
     * 返回当前指向的元素，并把指针指向上一个元素
     * @return 当前元素
     */
    public E prev() {
        if (node == null) {
            return null;
        }
        E item = node.item;
        node = node.prev;
        return item;
    }

    /**
     * 删除环形队列中的指定元素
     * @param e 要删除的元素
     * @return 删除结果
     */
    public boolean remove(E e) {
        if (e == null) {
            // 移除null元素时，不能使用equals方法判断，所以要单独拿出来
            for (Node<E> x = first; x != null ; x = x.next) {
                if (x.item == null) {
                    // 删除节点
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null ; x = x.next) {
                if (e.equals(x.item)) {
                    // 删除节点
                    unlink(x);
                    return true;
                }
            }
        }
        return true;
    }

    /**
     * 删除指定节点
     * @param node 要删除的节点
     * @return 被删除的元素
     */
    private E unlink(Node<E> node) {
        // 拿到该节点的所有属性
        E item = node.item;
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == node || next == node) {
            // 只有一个节点
            this.first = null;
            this.last = null;
            this.node = null;
        }

        next.prev = prev;
        prev.next = next;

        node.item = null;
        node = null;
        size--;
        return item;

    }

    /**
     * 返回当前指针指向的节点的元素
     * @return 当前指针指向的节点的元素
     */
    public E peek() {
        return node.item;
    }

    /**
     * 获取环形列表的大小
     * @return 环形列表的大小
     */
    public int size() {
        return this.size;
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
