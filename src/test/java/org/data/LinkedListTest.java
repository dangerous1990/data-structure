package org.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by limeng on 17-11-27.
 */
public class LinkedListTest {
    List<Integer> linkedList = new LinkedList<Integer>();

    @Before
    public void before() {
        for (int i = 0; i < 100; i++) {
            linkedList.add(i);
        }
    }

    @Test
    public void get() {
        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(i == linkedList.get(i).intValue());
        }
    }

    @Test
    public void remove() {
        linkedList.remove(0);
        int length = linkedList.size();
        for (int i = 0; i < length; i++) {
            Assert.assertTrue((i + 1) == linkedList.get(i).intValue());
        }
        Assert.assertFalse(linkedList.remove(101));
    }

    @Test
    public void set() {
        int length = linkedList.size();
        for (int i = 0; i < length; i++) {
            linkedList.set(i, 0);
        }
        for (int i = 0; i < length; i++) {
            Assert.assertTrue(0 == linkedList.get(i).intValue());
        }
    }

}
