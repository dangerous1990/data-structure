package org.data;

/**
 * 线性表
 * Created by limeng on 17-11-24.
 */
public interface List<E> {
    void add(E e);

    E get(int i);

    boolean set(int i,E e);

    boolean remove(E e);

    void clear();

    int size();

    boolean isEmpty();
}
