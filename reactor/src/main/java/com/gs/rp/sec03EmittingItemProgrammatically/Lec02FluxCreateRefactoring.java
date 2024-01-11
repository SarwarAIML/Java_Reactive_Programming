package com.gs.rp.sec03EmittingItemProgrammatically;

import com.gs.rp.courseutil.Util;
import com.gs.rp.sec03EmittingItemProgrammatically.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactoring {

    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer).subscribe(Util.subscriber());

        Runnable runnable = ()-> nameProducer.produce();

        for (int i = 1; i <= 10 ; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSecond(10);

    }
}