package org.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by limeng on 18-6-29.
 */
public class QuickSortTest {
    @Test
    public void testSort() {
        int[] arr = {2, 8, 9, 6, 8, 6, 10, 1, 0, 5, 7};
        QuickSort sort = new QuickSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
