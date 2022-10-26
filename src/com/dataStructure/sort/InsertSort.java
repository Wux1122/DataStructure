package com.dataStructure.sort;

import java.util.Arrays;

/**
 * 构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * e.g. 扑克牌理牌，，，
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {101,34,119,1};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {

            int insertVal = arr[i];
            int insertIndex = i -1 ;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }

            arr[insertIndex + 1] = insertVal;

            System.out.println(Arrays.toString(arr));

        }
    }
}
