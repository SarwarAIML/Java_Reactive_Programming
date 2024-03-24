package com.gs.rp.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test4 {

    public static void main(String[] args) {


     List<Emploee> list = new ArrayList<Emploee>();
        Emploee emploee = new Emploee("1","sarwar5");
        Emploee emploee1 = new Emploee("2","sarwar1");
        Emploee emploee2 = new Emploee("3","sarwar2");
        Emploee emploee3 = new Emploee("4","sarwar3");

        Comparator<Emploee> nameComparator = (Emploee o1, Emploee o2) ->o1.getName().compareTo(o2.getName());

       Comparator<Emploee> nameComparator1 = Comparator.comparing(Emploee::getName);
       Comparator<Emploee> idComparator = Comparator.comparing(Emploee::getId);


       list.add(emploee2);
        list.add(emploee1);
        list.add(emploee3);
        list.add(emploee);

        System.out.println("===============");
        list.stream().sorted(nameComparator1).map(emploee4 -> emploee4.getName()).forEach(name -> System.out.println(name));
        System.out.println("=======================");

        Collections.sort(list,idComparator);
        System.out.println(list);

    }
}