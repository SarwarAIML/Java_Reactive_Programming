package com.gs.rp.sec04Operators;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05Delay {

    public static void main(String[] args) {



            System.setProperty("rp.bufferSize.x", "9");

            Flux.range(1, 100)  // 32
                    .log()
                    .delayElements(Duration.ofSeconds(1))
                    .subscribe(Util.subscriber());



            Util.sleepSecond(60);
        }
    }