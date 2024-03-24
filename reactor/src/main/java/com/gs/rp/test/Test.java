package com.gs.rp.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        List<Integer> integers = List.of(1,7,11, 2, 3, 4, 5);
        List<Integer> collect = integers.stream().parallel().sorted().collect(Collectors.toList());
       // System.out.println(collect);
        //
        List<String> stringList = List.of("Bangalore","Ranchi","Hydrabada","Bangalore","Bangalore");

        List<String> stringList1 = new ArrayList<>();
        stringList1.add("ABC");
        stringList1.add("ABC1");
        stringList1.add("ABC2");


         String city = (String) Arrays.stream(stringList.toArray())
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                 .map(entryset-> entryset.getKey())
                .findFirst()
                .get();

     //   System.out.println(city);

//        return wordCounts.entrySet()
//                .stream()
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        ListIterator<String> listIterator = stringList1.listIterator();
        while (listIterator.hasNext()){
           String string =listIterator.next();
         //   stringList1.add("bbbb");
          //  System.out.println(string);
        }

        List<String> list = List.of("Hello", "World");
        StringBuilder builder = new StringBuilder();

        // o/p : :: Helowrd
      //  List<String> list = List.of("abc", "cde", "def", "afc");
        String collect1 = list.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .distinct()
                .collect(Collectors.toList()).toString();

    //    System.out.println(collect1);

        List<Integer> integerList = List.of(3, 1, 8, 34, 7, 5);
        List<Integer> collect2 = integerList.stream().filter(number -> number % 6 == 0).collect(Collectors.toList());
        System.out.println(collect2);





    }

}