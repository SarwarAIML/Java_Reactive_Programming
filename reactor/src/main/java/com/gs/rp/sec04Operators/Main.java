package com.gs.rp.sec04Operators;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Main {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.create(fluxSink -> {
            System.out.println("created");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        });
        Flux<Integer> cache = flux.filter(i -> i > 1).cache(1);

        cache.subscribe(Util.subscriber());
        cache.subscribe(Util.subscriber());
    }
}