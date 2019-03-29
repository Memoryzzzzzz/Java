package com.test.java;

import java.util.Arrays;

public class arrays01 {

    public static void main(String[] args) {

        // 给数组所有值批量赋值为2
        int[] arr = new int[5];
        Arrays.fill(arr,3);
        System.out.println(Arrays.toString(arr));

        // 给第1位到第4位赋值8（注：下标是从0开始，4不包括）
        int[] arr2 = new int[5];
        Arrays.fill(arr2,1,4,8);
        System.out.println(Arrays.toString(arr2));
    }
}
