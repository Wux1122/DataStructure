package com.dataStructure.sort;

import java.util.Arrays;

/**
 * 从欲排序的数据中，按指定的规则选出某一元素，再依规定交换未知后达到排序的目的
 */
public class SelectSort {
    public static void main(String[] args) {
    int arr[] = {11,65,32,27};
    selectSort(arr);
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {

            int min = arr[i];
            int minIndex = i;

            for (int j = i + 1; j <arr.length; j++) {
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }

            if(minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            System.out.println(Arrays.toString(arr));

        }




    }


}
