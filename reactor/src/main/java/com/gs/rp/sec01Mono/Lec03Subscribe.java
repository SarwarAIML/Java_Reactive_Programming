package com.gs.rp.sec01Mono;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03Subscribe {

    public static void main(String[] args) {

        Mono<Integer> mono = Mono.just("Ball")
                .map(string -> string.length()).map(len -> len/0);

        mono.subscribe(
          item -> System.out.println(item),
          err ->System.out.print(err.getMessage()),
            ()->System.out.print("Item consumed Successfully")
        );
        System.out.println("below is the equivalent code");
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
               Util.onComplete()
        );
    }
}