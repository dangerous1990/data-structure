package org.data;

/**
 * 循环队列，使用数组（线性表）实现
 * Created by limeng on 17-11-30.
 */
public class CycleArrayQueue<T> implements Queue<T> {
    private Object[] elements;
    int header = 0;
    int tail = 0;
    int size = 0;

    public CycleArrayQueue() {
        elements = new Object[10];
    }

    public CycleArrayQueue(int size) {
        elements = new Object[size];
    }


    @Override
    public void clear() {
        header = 0;
        tail = 0;
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return tail + 1 % elements.length == header;
    }

    @Override
    public void enQueue(T value) {
        if (isFull()) {
            throw new RuntimeException("queue is full!");
        }
        elements[tail] = value;
        //tail 右移一位
        tail = (tail + 1) % elements.length;
        size++;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }
        T result = (T) elements[header];
        elements[header] = null;
        //header 右移一位
        header = (header + 1) % elements.length;
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }
}
