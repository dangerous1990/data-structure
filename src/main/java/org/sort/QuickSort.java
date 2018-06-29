package org.sort;

/**
 * 快速排序，选取一个值把把数组分成2半，一半小于这个值，一半大于这个值
 * Created by limeng on 18-6-28.
 */
public class QuickSort implements Sort {


    public void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int k = partition(a, left, right);
            quickSort(a, left, k);
            quickSort(a, k + 1, right);
        }
    }

    private int partition(int[] a, int left, int right) {
        int i = left;
        int j = right;
        int temp = a[left];
        while (i != j) {
            //从右边找到小于“哨兵”
            while (a[j] >= temp && i < j) {
                j--;
            }
            //从左边找到大于“哨兵”
            while (a[i] < temp && i < j) {
                i++;
            }
            //相互交互位置
            if (i < j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        //把哨兵移动到中间
        a[left] = a[i];
        a[i] = temp;
        return i;
    }

    @Override
    public void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        this.quickSort(array, 0, array.length - 1);
    }
}
