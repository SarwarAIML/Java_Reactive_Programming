package com.gs.rp.test;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Test3 {

    public static void main(String[] args) {

        String string = "GeeksforGeeks";
        string.chars().mapToObj(ch->(char)ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .forEach(key->{
                    System.out.print(key.getKey()+":"+key.getValue()+"\t");
                });
    }
}