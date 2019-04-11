package com.test.spring.test;

/**
 * 对于严格递增的正整数数列A=a1、a2、……、an，如果一个正整数T满足：
 * 1）对于数列A中的任意元素x，如果x+T不大于an，则x+T也是数列A中的元素
 * 2）对于数列A中的任意元素x，如果x-T不小于a1，则x-T也是数列A中的元素
 * 那么称T为数列A的周期，如果同时满足：
 * 3）所有小于T的正整数，都不是A的周期
 * 则称T为A的最小周期
 * 输入描述:
 * 每组测试样本的输入格式为：
 * 第一行是一个正整数N
 * 从第二行开始，每行有若干个正整数，依次存放n、a1、a2、……、an，一共有N行，也就是N个数列。
 * 输出描述:
 * 输出有N行，每行打印出对应数列的最小周期。
 * 示例1
 * 输入
 * 3
 * 3 1 2 3
 * 3 2 4 6
 * 3 3 4 6
 * 输出
 * 1
 * 2
 * 3
 */
public class test {

    public static void main(String[] args) {

    }
}
