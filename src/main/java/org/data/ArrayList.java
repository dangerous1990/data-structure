package org.data;

/**
 * Created by limeng on 17-11-24.
 */
public class ArrayList<T> implements List<T> {

    private Object[] elemets = new Object[100];
    private int size = 0;
    private int index = 0;

    @Override
    public void add(T value) {
        elemets[size++] = value;
    }

    @Override
    public T get(int i) {
        if (i > size) {
            throw new ArrayIndexOutOfBoundsException("i > " + size);
        }
        return (T) elemets[i];
    }


    @Override
    public boolean set(int i, T t) {
        if (i > size) {
            throw new ArrayIndexOutOfBoundsException("i > " + size);
        }
        elemets[i] = t;
        return false;
    }

    @Override
    public boolean remove(T t) {
        if (null == t) {
            throw new NullPointerException("element is null");
        }
        int length = elemets.length;
        for (int i = 0; i < length; i++) {
            if (t == elemets[i] || t.equals(elemets[i])) {
                //向前移动
                for (int j = i; j < length; j++) {
                    if (j + 1 != length) {
                        elemets[j] = elemets[j + 1];
                    }
                }
                // clear to let GC do its work
                elemets[--size] = null;
                return true;
            }
        }
        return false;
    }


    @Override
    public void clear() {
        // clear to let GC do its work
        for (int i = 0; i < size; i++) {
            elemets[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
