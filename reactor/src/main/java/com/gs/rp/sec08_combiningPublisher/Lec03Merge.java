package com.gs.rp.sec08_combiningPublisher;


import com.gs.rp.courseutil.Util;
import com.gs.rp.sec08_combiningPublisher.helper.AmericanAirlines;
import com.gs.rp.sec08_combiningPublisher.helper.Emirates;
import com.gs.rp.sec08_combiningPublisher.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lec03Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericanAirlines.getFlights()
        );

        merge.subscribe(Util.subscriber());

        Util.sleepSecond(10);

    }


}