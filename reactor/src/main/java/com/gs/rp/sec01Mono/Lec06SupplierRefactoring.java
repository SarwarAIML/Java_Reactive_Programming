package com.gs.rp.sec01Mono;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {

        getName();
        getName().subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());
        getName();
        //block is the subscriber who blocks the main thread and act as subscriber
        // ,not the recommended way of doing .

        String name = getName().subscribeOn(Schedulers.boundedElastic()).block();
        System.out.println(name);
        getName();

        Util.sleepSecond(4);

    }

    private static Mono<String> getName(){
        System.out.println("Entered getName method::");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating Name::");
            Util.sleepSecond(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);

    }
}