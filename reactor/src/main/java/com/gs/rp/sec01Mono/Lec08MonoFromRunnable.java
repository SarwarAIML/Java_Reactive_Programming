package com.gs.rp.sec01Mono;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {
        Mono.fromRunnable(timeconsumingProcess()).subscribe(
                Util.onNext(),
                Util.onError(),
                ()->{
                    System.out.println("process is done sending messages");
                }
        );

    }

    private static Runnable timeconsumingProcess(){
        return (() ->{
            Util.sleepSecond(3);
            System.out.println("Operation Completed");
        });
    }
}