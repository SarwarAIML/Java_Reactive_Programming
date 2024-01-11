package com.gs.rp.sec08_combiningPublisher.helper;


import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Emirates {

    public static Flux<String> getFlights(){
        return Flux.range(1, Util.faker().random().nextInt(1, 10))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Emirates " + Util.faker().random().nextInt(100, 999))
                .filter(i -> Util.faker().random().nextBoolean());
    }


}