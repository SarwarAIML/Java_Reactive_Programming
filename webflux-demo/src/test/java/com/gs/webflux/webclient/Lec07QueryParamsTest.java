package com.gs.webflux.webclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.net.URI;
import java.util.Map;

public class Lec07QueryParamsTest extends BaseTest{

    @Autowired
    WebClient webClient ;

    String string = "http://localhost:8080/jobs/search?count={count}&page={page}";


    @Test
    public void queryParamTest1(){
        URI uri = UriComponentsBuilder.fromUriString(string).build(10,20);
        Flux<Integer> integerFlux = webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Integer.class)
                .doOnNext(System.out::println);
        StepVerifier.create(integerFlux)
                .expectNextCount(2)
                .verifyComplete();

    }
    Map<String,Integer> map = Map.of("count",10,"page",20);
    @Test
    public void queryParamTest2() {
        Flux<Integer> integerFlux = this.webClient.get()
                .uri(builder -> builder.path("jobs/search").query("count={count}&page={page}").build(map))
                .retrieve()
                .bodyToFlux(Integer.class)
                .doOnNext(System.out::println);

        StepVerifier.create(integerFlux)
                .expectNextCount(2)
                .verifyComplete();

    }
}