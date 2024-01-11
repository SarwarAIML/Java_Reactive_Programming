package com.gs.rp.sec02Flux;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.io.Serializable;

public class Lec01FluxIntro {

    public static void main(String[] args) {


        Flux<Object> flux = Flux.just(1, 2, 3, "a", Util.faker().name().fullName());

        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}