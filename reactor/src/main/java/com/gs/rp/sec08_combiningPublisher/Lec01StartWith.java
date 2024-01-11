package com.gs.rp.sec08_combiningPublisher;


import com.gs.rp.courseutil.Util;
import com.gs.rp.sec08_combiningPublisher.helper.NameGenerator;

public class Lec01StartWith {

    public static void main(String[] args) {


        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));

        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));

        generator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("Jake"));

        generator.generateNames()
                .filter(n -> n.startsWith("A"))
                .take(2)
                .subscribe(Util.subscriber("Marshal"));


    }


}