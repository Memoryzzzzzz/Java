package com.test.java;

import java.util.ArrayList;
import java.util.List;

public class arrayData02 {

    public static void main(String[] args) {

        int[] data = new int[4];
        System.out.println(data.length);

        List<String> dataList = new ArrayList<>();
        System.out.println(dataList.size());
        dataList.add("dataList");
        System.out.println(dataList.size());
        dataList.remove(0);
        System.out.println(dataList.size());

    }
}
