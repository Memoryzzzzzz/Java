package com.test.java;

import java.util.Arrays;

public class arrays02 {

    public static void main(String[] args) {

        // 给所有数按照升序排列
        int[] arr = {88, 11, 44, 22, 99, 33, 77, 55, 66};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 给第3位到第6位排序（注：下标是从0开始，4不包括）
        int[] arr2 = {88, 11, 44, 22, 99, 33, 77, 55, 66};
        Arrays.sort(arr2,3,6);
        System.out.println(Arrays.toString(arr2));

    }
}
