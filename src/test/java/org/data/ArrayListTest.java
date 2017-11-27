package org.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by limeng on 17-11-27.
 */
public class ArrayListTest {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    @Before
    public void before() {
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }
    }

    @Test
    public void get() {
        for (int i = 0; i < 100; i++) {
            Assert.assertTrue(i == arrayList.get(i).intValue());
        }
    }

    @Test
    public void remove() {
        arrayList.remove(0);
        int length = arrayList.size();
        for (int i = 0; i < length; i++) {
            Assert.assertTrue((i + 1) == arrayList.get(i).intValue());
        }
        Assert.assertFalse(arrayList.remove(101));
    }

}
