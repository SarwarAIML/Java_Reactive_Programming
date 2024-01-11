package com.gs.rp.sec03EmittingItemProgrammatically;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
                    System.out.println("emitting");
                    synchronousSink.next(Util.faker().country().name()); // 1
                    //synchronousSink.error(new RuntimeException("oops"));
                })
                .take(4)
                .subscribe(Util.subscriber());


    }
}