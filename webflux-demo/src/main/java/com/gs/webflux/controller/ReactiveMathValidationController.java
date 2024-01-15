package com.gs.webflux.controller;


import com.gs.webflux.dto.Response;
import com.gs.webflux.exception.InputValidationException;
import com.gs.webflux.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive-math")
public class ReactiveMathValidationController {
    @Autowired
    ReactiveMathService reactiveMathService;

    @GetMapping("square/{input}/throw")
    public Mono<Response> findSquare(@PathVariable int input){
      //  if (input < 10 || input > 20)
      //      throw new InputValidationException(input);
        return this.reactiveMathService.findSquare(input);
    }

    @GetMapping("square/{input}/mono-error")
    public Mono<Response> monoError(@PathVariable int input)
    {
        return Mono.just(input)
                .handle((integer, sink) -> {
                    if (input >= 10 && input <= 20){
                        sink.next(input);
                    }else {
                        sink.error(new InputValidationException(input));
                    }
                }
                ).cast(Integer.class)
                .flatMap(integer -> this.findSquare(integer));
    }

    @GetMapping("square/{input}/assignment")
    public Mono<ResponseEntity<Response>> assignment(@PathVariable int input)
    {
        return Mono.just(input)
                .filter( integer -> integer >=10 && integer <=20)
                .flatMap(integer ->  this.findSquare(integer))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}