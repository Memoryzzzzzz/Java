package com.test.java;

public class arrayData01 {

    public static void main(String[] args) {

        int[] a;    // 推荐方法
        int b[];    // C 写法

//        a = new int[];    // 错误写法
        int[] c = new int[4];

        c[0] = 1;
        c[1] = 2;
        c[2] = 3;
        c[3] = 4;

        int[] d = {1, 2, 3, 4};

        for (int i : d) {
            System.out.print(i + "");
        }
    }
}
