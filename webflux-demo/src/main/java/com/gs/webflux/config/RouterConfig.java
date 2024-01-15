package com.gs.webflux.config;


import com.gs.webflux.dto.InputFailedValidationResponse;
import com.gs.webflux.exception.InputValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Configuration
public class RouterConfig {
    @Autowired
    private RequestHandler requestHeader;

    @Bean
    public RouterFunction<ServerResponse> HighLevelRouter() {
        return RouterFunctions.route()
                .path("router",this::serverResponseRouterFunction)
                .build();
    }

    private RouterFunction<ServerResponse> serverResponseRouterFunction() {
        return RouterFunctions.route()
                .GET("square/{input}",RequestPredicates.path("*/1?"), requestHeader::squareHandler)
                .GET("square/{input}",req-> ServerResponse.badRequest().bodyValue("only 10 t0 19 are allowed "))
                .GET("table/{input}", requestHeader::tableHandler)
                .GET("table/{input}/stream", requestHeader::tableStreamHandler)
                .POST("multiply", requestHeader::multiplyHandler)
             //   .GET("square/{input}/validation", requestHeader::squareHandlerWithValidation)
                .onError(InputValidationException.class, exceptionHandler())
                .build();
    }




    private RouterFunction<ServerResponse> serverResponseRouterFunction_back() {
        return RouterFunctions.route()
                .GET("square/{input}", requestHeader::squareHandler)
                .GET("table/{input}", requestHeader::tableHandler)
                .GET("table/{input}/stream", requestHeader::tableStreamHandler)
                .POST("multiply", requestHeader::multiplyHandler)
                .GET("square/{input}/validation", requestHeader::squareHandlerWithValidation)
                .onError(InputValidationException.class, exceptionHandler())
                .build();
    }
    private BiFunction<Throwable, ServerRequest, Mono<ServerResponse>> exceptionHandler() {
        return (err, req) -> {
            InputValidationException ex = (InputValidationException) err;
            InputFailedValidationResponse response = new InputFailedValidationResponse();
            response.setInput(ex.getInput());
            response.setErrorCode(ex.getErrorCode());
            response.setErrorMessage(ex.getMessage());
            return ServerResponse.badRequest().bodyValue(response);
        };
    }
}