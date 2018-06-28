package org.sort;

/**
 * 归并排序，分治
 * Created by limeng on 18-6-28.
 */
public class MergeSort {
    private int[] tempArray;

    public void sort(int[] arr) {
        tempArray = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, high);
    }

    private void merge(int[] array, int low, int high) {
        int i = low;
        int mid = (low + high) / 2;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }
        while (i <= mid) {
            tempArray[k++] = array[i++];
        }
        while (j <= high) {
            tempArray[k++] = array[j++];
        }

        for (i = low; i <= high; i++) {
            array[i] = tempArray[i];
        }
    }


}
