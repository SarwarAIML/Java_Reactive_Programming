package com.gs.rp.sec01Mono;

import reactor.core.publisher.Mono;

public class Lec02JustMono {

    public static void main(String[] args) {


        //publisher
        Mono<Integer> mono = Mono.just(1);

        mono.subscribe(integer -> System.out.print("Received ::"+integer));
    }
}