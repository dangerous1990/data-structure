package org.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 单向链表循环测试
 * Created by limeng on 18-6-20.
 */
public class CycleLinkedListTest {
    CycleLinkedList<Integer> linkedList = new CycleLinkedList<>();

    @Before
    public void before() {
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }
    }

    @Test
    public void get() {
        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(i, linkedList.get(i).intValue());
        }
    }

    @Test
    public void remove() {
        linkedList.remove(0);
        int size = linkedList.size();
        Assert.assertEquals(99, size);
        for (int i = 0; i < size; i++) {
            Object value = linkedList.get(i);
            Assert.assertEquals(i + 1, value);
        }
        Assert.assertFalse(linkedList.remove(101));
    }
}
