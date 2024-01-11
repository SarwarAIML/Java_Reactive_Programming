package com.gs.rp.sec02Flux;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {

    public static void main(String[] args) {


        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

        Flux<Integer> evenFlux = integerFlux.filter(integer -> integer % 2 == 0);

        integerFlux.subscribe(integer -> System.out.println("Sub1::"+integer));
        evenFlux.subscribe(integer -> System.out.println("Sub2::"+integer));
    }
}