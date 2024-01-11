package com.gs.rp.sec04Operators;


import com.gs.rp.courseutil.Util;
import com.gs.rp.sec04Operators.helper.OrderService;
import com.gs.rp.sec04Operators.helper.UserService;
import reactor.core.publisher.Flux;

public class Lec12FlatMap {

    public static void main(String[] args) {


        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId())) // mono / flux

                .subscribe(Util.subscriber());

        Util.sleepSecond(60);


        Flux<Integer> flux = Flux.create(fluxSink -> {
            System.out.println("created");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
        });
        Flux<Integer> map = flux.map(i -> i * 2);
        map.subscribe(System.out::println);
        map.subscribe(System.out::println);


    }


}