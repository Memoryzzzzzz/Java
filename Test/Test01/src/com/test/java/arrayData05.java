package com.test.java;

public class arrayData05 {

    public static void main(String[] args) {
        // 根据行数定义好二维数组，由于每一行的元素不同，所以设置动态初始化
        int[][] arr = new int[5][];
        // 遍历二维数组
        for(int i = 0; i < arr.length; i++){
            // 初始化每一行的一维数组
            arr[i] = new int[i+1];
            // 遍历这个一维数组，添加元素
            for(int j = 0; j <= i; j++){
                // 每一列的开头和结尾元素为1，开头的时候，j = 0,结尾的时候，j = i
                if(j == 0 || j == i){
                    arr[i][j] = 1;
                } else {
                    // 每一个元素是它上一行的元素和斜对角元素之和
                    arr[i][j] = arr[i-1][j] + arr[i - 1][j - 1];
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
