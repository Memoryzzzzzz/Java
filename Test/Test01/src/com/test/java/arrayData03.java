package com.test.java;

import java.util.Arrays;

public class arrayData03 {

    public static void main(String[] args) {
//        insertionSort();

        int srcArray[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 88));
    }

    public static void bubbleSort() {
        int[] arr = {88, 11, 44, 22, 99, 33, 77, 55, 66};
        for (int i = 0; i < arr.length - 1; i++) {
            boolean judge = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {        // 相邻元素两两对比
                    int temp = arr[j + 1];        // 元素交换
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    judge = true;
                }
            }
            if (!judge) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort() {
        int[] arr = {88, 11, 44, 22, 99, 33, 77, 55, 66};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {     // 寻找最小的数
                    minIndex = j;                 // 将最小数的索引保存
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort() {
        int[] arr = {88, 11, 44, 22, 99, 33, 77, 55, 66};
        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }

        System.out.println(Arrays.toString(arr));
    }

    private static int binSearch(int srcArray[], int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }
}
