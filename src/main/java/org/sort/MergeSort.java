package org.sort;

/**
 * 归并排序，分治，时间复杂度稳定，不会因为数据变化，而产生变化
 * Created by limeng on 18-6-28.
 */
public class MergeSort implements Sort {
    private int[] tempArray;

    @Override
    public void sort(int[] arr) {
        tempArray = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int low, int high) {
        // note不会出现low > high的情况
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, high);
    }

    /**
     * 把连个有序数组合并成一个有序数组
     *
     * @param array
     * @param low
     * @param high
     */
    private void merge(int[] array, int low, int high) {
        int i = low;
        int mid = (low + high) / 2;
        int j = mid + 1;
        int k = low;
        // 2个指针 找到最小值后+1
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }
        // 剩余所有左侧部分，添加到数组后面
        while (i <= mid) {
            tempArray[k++] = array[i++];
        }
        // 剩余右侧部分，添加数组后面
        while (j <= high) {
            tempArray[k++] = array[j++];
        }
        // 复制已排好顺序的到原数组
        for (i = low; i <= high; i++) {
            array[i] = tempArray[i];
        }
    }


}
