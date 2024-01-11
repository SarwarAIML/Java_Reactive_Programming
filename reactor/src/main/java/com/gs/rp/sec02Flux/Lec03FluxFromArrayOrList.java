package com.gs.rp.sec02Flux;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {

    public static void main(String[] args) {

         List<String> strings = Arrays.asList("a", "b", "c");
         Flux.fromIterable(strings)
                .subscribe(Util.onNext());
        Util.sleepSecond(3);
        System.out.println("===============");
         Integer[] arr = {2,4,6,8};
         Flux.fromArray(arr).subscribe(Util.onNext());
    }
}