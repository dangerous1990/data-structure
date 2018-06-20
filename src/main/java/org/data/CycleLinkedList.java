package org.data;

/**
 * 单向循环链表
 * Created by limeng on 18-6-19.
 */
public class CycleLinkedList implements List {
    private Node fakeHead = new Node(null);
    private Node tail;
    private int size = 0;

    public CycleLinkedList() {
    }

    @Override
    public void add(Object o) {
        if (null == tail) {
            tail = new Node(o);
            fakeHead.next = tail;
            // 指向头节点
            tail.next = fakeHead.next;
        } else {
            tail.next = new Node(o);
            tail = tail.next;
            // 指向头节点
            tail.next = fakeHead.next;
        }
        size++;
    }

    @Override
    public Object get(int i) {
        int index = 0;
        Node current = fakeHead.next;
        while (index < size) {
            if (i == index) {
                return current.value;
            } else {
                current = current.next;
                index++;
            }

        }
        return null;
    }

    @Override
    public boolean set(int i, Object o) {
        int index = 0;
        Node current = fakeHead.next;
        while (index < size) {
            if (i == index) {
                current.value = o;
                return true;
            } else {
                current = current.next;
            }
            index++;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node current = fakeHead.next;
        int index = 0;
        while (index < size) {
            if (current.value.equals(o)) {
                // 指向下个节点
                current.value = current.next.value;
                current.next = current.next.next;
                size--;
                return true;
            } else {
                current = current.next;
            }
            index++;
        }
        return false;
    }

    @Override
    public void clear() {
        // TODO 是否会造成内存泄露？
        fakeHead.next = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return fakeHead.next != null;
    }

    private class Node {
        CycleLinkedList.Node next;
        Object value;

        Node(Object value) {
            this.value = value;
        }
    }
}
