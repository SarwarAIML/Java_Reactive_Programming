package com.gs.rp.test;

import java.util.List;


public class Test2 {

    public static void main(String[] args) {

        List<Integer> integerList = List.of(3, 1, 8, 34, 7, 5);
        integerList.stream().anyMatch(Number-> Number%6==0);

        String str = "abc def ghi";
        System.out.println(str.substring(7));
        System.out.println(str.substring(0, 6));



    }
}