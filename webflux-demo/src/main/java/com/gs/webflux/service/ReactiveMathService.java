package com.gs.webflux.service;


import com.gs.webflux.dto.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveMathService {

    public Mono<Response> findSquare(int input){
        return Mono.fromSupplier(() -> input * input)
                    .map(Response::new);
    }

    public Flux<Response> multiplicationTable(int input){
        return Flux.range(1, 10)
                    .delayElements(Duration.ofSeconds(1))
                    //.doOnNext(i -> SleepUtil.sleepSeconds(1))
                    .doOnNext(i -> System.out.println("reactive-math-service processing : " + i))
                    .map(i -> new Response(i * input));
    }


}