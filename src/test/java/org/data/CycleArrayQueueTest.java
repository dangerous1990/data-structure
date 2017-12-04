package org.data;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by limeng on 17-12-4.
 */
public class CycleArrayQueueTest {
    @Test
    public void enQueue() {
        CycleArrayQueue<Integer> cycleArrayQueue = new CycleArrayQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            cycleArrayQueue.enQueue(i);
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(new Integer(i), cycleArrayQueue.deQueue());
        }
    }

    @Test
    public void enQueueFull() {
        CycleArrayQueue<Integer> cycleArrayQueue = new CycleArrayQueue<Integer>();
        try {
            for (int i = 0; i < 11; i++) {
                cycleArrayQueue.enQueue(i);
            }
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "queue is full!");

        }
    }

    @Test
    public void clear() {
        CycleArrayQueue<Integer> cycleArrayQueue = new CycleArrayQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            cycleArrayQueue.enQueue(i);
        }
        cycleArrayQueue.clear();
        Assert.assertTrue(cycleArrayQueue.isEmpty());
    }

    @Test
    public void isEmpty() {
        CycleArrayQueue<Integer> cycleArrayQueue = new CycleArrayQueue<Integer>();
        Assert.assertTrue(cycleArrayQueue.isEmpty());
        for (int i = 0; i < 10; i++) {
            cycleArrayQueue.enQueue(i);
        }
        cycleArrayQueue.clear();
        Assert.assertTrue(cycleArrayQueue.isEmpty());
        cycleArrayQueue.enQueue(1);
        Assert.assertFalse(cycleArrayQueue.isEmpty());
    }

    @Test
    public void deQueue() {
        CycleArrayQueue<Integer> cycleArrayQueue = new CycleArrayQueue<Integer>();
        try {
            cycleArrayQueue.deQueue();
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "queue is empty!");
        }
        for (int i = 0; i < 10000; i++) {
            cycleArrayQueue.enQueue(i);
            Assert.assertEquals(new Integer(i), cycleArrayQueue.deQueue());
        }
    }

}
