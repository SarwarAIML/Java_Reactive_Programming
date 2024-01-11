package com.gs.rp.sec06_Thread;



import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07FluxInterval {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .log()
                .subscribe(Util.subscriber());


        Util.sleepSecond(60);
    }

}