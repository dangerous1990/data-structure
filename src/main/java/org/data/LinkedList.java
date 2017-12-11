package org.data;

/**
 * 单链表
 * Created by limeng on 17-12-11.
 */
public class LinkedList<T> implements List<T> {
    private int size = 0;

    private Node head;
    private Node tail;

    @Override
    public void add(Object value) {
        if (null == head) {
            tail = new Node(value);
            head = tail;
        } else {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int i) {
        if (null == head) {
            throw new IllegalStateException("list is empty");
        }
        if (i == 0) {
            return (T) head.value;
        }
        int count = 1;
        Node next = head.next;
        while (null != next) {
            if (count++ == i) {
                return (T) next.value;
            }
            next = next.next;
        }
        return null;
    }

    @Override
    public boolean set(int i, Object value) {
        if (i > size) {
            throw new IndexOutOfBoundsException("i > size");
        }
        int count = 0;
        Node next = head;
        while (null != next) {
            if (count++ == i) {
                next.value = value;
            }
            next = next.next;
        }
        return false;
    }

    @Override
    public boolean remove(Object value) {
        if (null != head && head.value == value) {
            head = head.next;
            size--;
            return true;
        }
        Node prev = head;
        Node next = head.next;
        while (null != next) {
            if (next.value == value || value.equals(next.value)) {
                prev.next = next.next;
                size--;
                return true;
            }
            next = next.next;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    private class Node {
        Node next;
        Object value;

        Node(Object value) {
            this.value = value;
        }
    }
}
