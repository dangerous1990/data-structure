package org.sort;

import org.junit.Test;
import org.sort.MergeSort;

import java.util.Arrays;

/**
 * Created by limeng on 18-6-28.
 */
public class MergeSortTest {
    @Test
    public void testSort() {
        int[] arr = {2, 8, 9, 6, 8, 6, 10, 1, 0, 5, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
