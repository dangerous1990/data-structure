package org.data;

/**
 * Created by limeng on 17-11-30.
 */
public interface Queue<T> {

    void clear();

    boolean isEmpty();

    void enQueue(T value);

    T deQueue();

    int size();

}
