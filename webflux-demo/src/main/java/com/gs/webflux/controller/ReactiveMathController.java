package com.gs.webflux.controller;


import com.gs.webflux.dto.MultiplyRequestDTO;
import com.gs.webflux.dto.Response;
import com.gs.webflux.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("reactive-math")
public class ReactiveMathController {

    @Autowired
    ReactiveMathService reactiveMathService;

    @GetMapping("square/{input}")
    public Mono<Response> findSquare(@PathVariable int input){

        return this.reactiveMathService.findSquare(input);
    }

    @GetMapping("table/{input}")
    public Flux<Response> multiplicationTable(@PathVariable int input){
        return this.reactiveMathService.multiplicationTable(input);
    }

    @GetMapping(value = "table/{input}/stream"  , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> multiplicationTableStream(@PathVariable int input){
        return this.reactiveMathService.multiplicationTable(input);
    }

    @PostMapping("multiply")
    public Mono<Response> multiply(@RequestBody Mono<MultiplyRequestDTO> monodto,
                                   @RequestHeader Map<String,String> stringMap){
        System.out.println("Request Header :"+stringMap);
        return this.reactiveMathService.multiply(monodto);
    }



}