package com.gs.rp.sec01Mono;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        //use just when you have date already
     //   Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = () -> getName();
        Mono.fromSupplier(stringSupplier).subscribe(Util.onNext());

        Callable<String> callable = () -> getName();
        Mono.fromCallable(callable).subscribe(Util.onNext());

    }
    private static String getName(){
        System.out.println("Generating Name::");
        return Util.faker().name().fullName();
    }
}