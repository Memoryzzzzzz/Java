package com.test.java;

public class arrayData04 {

    public static void main(String[] args) {

        int a[][];
        int[][] b;
        int[] c [];

        int datas[][] = new int[3][];
        datas[0] = new int[6];
        datas[1] = new int[8];
        datas[2] = new int[5];

        int data[][] = {{1,2,3},{4,5,6,7,8},{9,10}};
//        System.out.println("第一行第三个的值：" + data[0][2]);
//        System.out.println("第二行第二个的值：" + data[1][1]);
//        System.out.println("第三行第一个的值：" + data[2][0]);

//        System.out.println(data.length);
//        System.out.println(data[1].length);

        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }


    }
}
