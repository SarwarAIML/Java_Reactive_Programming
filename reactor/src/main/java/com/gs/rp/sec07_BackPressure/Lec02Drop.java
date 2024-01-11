package com.gs.rp.sec07_BackPressure;


import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;


public class Lec02Drop {

    public static void main(String[] args) {
        // 75% 12
        System.setProperty("rp.bufferSize.small", "16");

        List<Object> list = new ArrayList<>();

        Flux.create(fluxSink -> {
                    for (int i = 1; i < 201; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : " + i);
                        Util.sleepMillis(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureDrop(list::add)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                })
                .subscribe(Util.subscriber());


        Util.sleepSecond(10);
        System.out.println(list);

    }


}