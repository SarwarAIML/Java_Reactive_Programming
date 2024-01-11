package com.gs.rp.sec01Mono;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {

    public static void main(String[] args) {

        Mono.fromFuture(getName()).subscribe(Util.onNext());


        Util.sleepSecond(1);

    }
    private static CompletableFuture<String> getName(){
        return  CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}