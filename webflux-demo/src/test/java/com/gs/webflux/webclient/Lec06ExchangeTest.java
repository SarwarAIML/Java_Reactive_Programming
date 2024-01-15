package com.gs.webflux.webclient;

import com.gs.webflux.dto.InputFailedValidationResponse;
import com.gs.webflux.dto.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Lec06ExchangeTest extends BaseTest{

    @Autowired
    private WebClient webClient;

    @Test
    public void badRequestTest(){

        //Exchange  = retrieve + https status code etc

        Mono<Object> responseMono = this.webClient
                .get()
                .uri("reactive-math/square/{number}/throw", 5)
                .exchangeToMono(this::exchange)
                .doOnNext(System.out::println)
                .doOnError(err -> System.out.println(err.getMessage()));

        StepVerifier.create(responseMono)
                .expectNextCount(1)
                .verifyComplete();

    }

    private Mono<Object> exchange(ClientResponse cr ){
        if (cr.statusCode().is4xxClientError())
            return cr.bodyToMono(InputFailedValidationResponse.class);
        else
            return cr.bodyToMono(Response.class);
    }
}