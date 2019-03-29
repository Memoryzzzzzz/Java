package com.test.java;

import java.util.Arrays;

/**
 * <img src="https://a1.gystatic.com/v6/images/logo.png" height="40" />
 *
 * @author 帅君豪 at 2019-03-25 19:37
 */
public class MySortTest {

    public static void main(String[] args) {
        insertionSortTest2();
    }

    /**
     * 冒泡排序（最坏情况）
     * n^2/2-n/2
     *
     */
    public static void bubbleSortTest() {
        //int[] arrags = {3,44,38,5,47,15,36,27,2,46,4,19,50,48};
        int[] array = {50,48,47,46,44,38,36,27,19,15,5,4,3,2};

        int a=0;
        for (int j = 0; j<array.length-1; j++) {
            for (int i = 0; i< array.length-j-1; i++) {
                int n;

                if (array[i] > array[i+1]) {
                    n = array[i];
                    array[i] = array[i+1];
                    array[i+1] = n;
                }
                a++;
                //System.out.println(Arrays.toString(arrags));
            }
            //System.out.println("===============================================");
            //System.out.println(Arrays.toString(arrags));
        }

        System.out.println(a);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序（最好情况）
     * n-1 次
     */
    public static void bubbleSortTest1() {
        //int[] arrags = {3,44,38,5,47,15,36,27,2,46,4,19,50,48};
        //int[] array = {50,48,47,46,44,38,36,27,19,15,5,4,3,2};
        int[] array = {2, 3, 4, 5, 15, 19, 27, 36, 38, 44, 46, 47, 48,50};

        int a=0;
        int b=0;
        for (int j = 0; j<array.length-1; j++) {
            a++;
            boolean swapped = false;
            for (int i = 0; i< array.length-j-1; i++) {
                int n;

                if (array[i] > array[i+1]) {
                    n = array[i];
                    array[i] = array[i+1];
                    array[i+1] = n;
                    swapped = true;
                }

                b++;
                //System.out.println(Arrays.toString(arrags));
            }
            if(!swapped) {
                break;
            }

            //System.out.println("===============================================");
            //System.out.println(Arrays.toString(arrags));
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(Arrays.toString(array));
    }
    /**
     * 选择排序
     */
    public static void selectionSortTest() {
        int[] array = {3,44,38,5,47,15,36,27,2,46,4,19,50,48};
       // int[] array = {2, 3, 4, 5, 15, 19, 27, 36, 38, 44, 46, 47, 48,50};

        int aa=0;
        for (int i = 0; i<array.length; i++) {
            int arr = i;
            for (int j= i+1; j < array.length; j++) {
                if (array[j] < array[arr]) {
                    arr = j;
                }
                aa++;
            }

            if (arr > i) {
                int a = array[i];
                array[i] = array[arr];
                array[arr] = a;
            }


            System.out.println(Arrays.toString(array));
            System.out.println("===============================================");
        }

        System.out.println(aa++);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序（最坏情况）
     * n^2/2-n/2
     *
     */
    public static void insertionSortTest1() {
        int[] array = {3,44,38,5,47,15,36,27,2,46,4,19,50,48};
        //int[] array = {50,48,47,46,44,38,36,27,19,15,5,4,3,2};

        int aa = 0;
        for (int i=1; i< array.length; i++) {
            for (int j = i; j >= 1; j --) {
                if (array[j]<array[j-1]) {
                    int a = array[j];
                    array[j] = array[j-1];
                    array[j-1] = a;
                } else {
                    break;
                }
                aa++;
                System.out.println(Arrays.toString(array));
            }
            System.out.println("==================");
        }
        System.out.println(aa);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序（最好情况）
     * n-1
     */
    public static void insertionSortTest2() {
//        int[] array = {3,44,38,5,47,15,36,27,2,46,4,19,50,48};
        int[] array = {2, 3, 4, 5, 15, 19, 27, 36, 38, 44, 46, 47, 48, 50};

        int aa = 0;
        int bb = 0;
        for (int i=1; i< array.length; i++) {

            int j = i;
            while (j >=1 && array[j]<array[j-1]) {

                int a = array[j];
                array[j] = array[j-1];
                array[j-1] = a;

                j--;
                aa++;
            }
            bb++;
        }

        System.out.println(aa);
        System.out.println(bb);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序
     */
    public static void shellSortTest() {
        //int[] array = {3,44,38,5,47,15,36,2,46,4,19,50,48,24};
        int[] array = {2, 3, 4, 5, 15, 19, 27, 36, 38, 44, 46, 47, 48, 50};

        int gen = array.length/2;

        int aa =0;
        int bb = 0;
        while(gen > 0) {
            for (int i=gen; i<array.length; i++) {
                bb++;
                int j = i;
                while (j >=gen && array[j]<array[j-gen]) {

                    int a = array[j];
                    array[j] = array[j-gen];
                    array[j-gen] = a;

                    j -= gen;
                    //System.out.println(Arrays.toString(array));
                    //System.out.println(gen);
                    aa++;
                }
                //System.out.println("=====================");
            }

            gen /= 2;
        }

        System.out.println(bb);
        System.out.println(aa);
        System.out.println(Arrays.toString(array));
    }
}
