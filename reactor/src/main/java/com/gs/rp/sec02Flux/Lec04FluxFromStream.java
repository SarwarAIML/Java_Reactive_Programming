package com.gs.rp.sec02Flux;

import com.gs.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {


        List<Integer> integerList = List.of(1, 4, 6, 7, 8, 9);
        Stream<Integer> integerStream = integerList.stream();
        Flux<Integer> integerFlux = Flux.fromStream(() -> integerList.stream());

        integerFlux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
        integerFlux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}