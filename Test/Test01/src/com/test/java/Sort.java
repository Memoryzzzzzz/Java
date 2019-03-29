package test.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * <img src="https://a1.gystatic.com/v6/images/logo.png" height="40" />
 *
 * @author 帅君豪 at 2019-01-25 9:59
 */
public class Sort {

    public static void main(String[] args) {

        //冒泡排序
        //bubbleSort();

        //选择排序
        //selectionSort();

        //插入排序
        //insertionSort();

        //希尔排序
        //shellSort();

        int srcArray[] = {3,5,11,17,21,23,28,32,50,64,78,81,95,101};
        System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 81));
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort() {

        int[] array = {23,12,48,56,45};

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     */
    private static void selectionSort() {

        int[] array = {23,12,48,56,45};

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]){ //找到最小的数
                    minIndex = j; //将最小数的索引保存
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     */
    private static void insertionSort() {

        int[] array = {23,12,48,56,45};

        for (int i=1; i< array.length; i++) {

            int j = i;
            while (j >=1 && array[j]<array[j-1]) {

                int a = array[j];
                array[j] = array[j-1];
                array[j-1] = a;

                j--;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序
     */
    private static void shellSort() {
        int[] array = {23,12,48,56,45};

        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * 二分查找法
     *
     * @param srcArray
     * @param start
     * @param end
     * @param key
     * @return
     */
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
