package com.gs.rp.sec02Flux;

import com.gs.rp.courseutil.Util;
import com.gs.rp.sec02Flux.helper.NameGenerator;

public class Lec07FluxVsList {

    public static void main(String[] args) {

        // List<String> names = NameGenerator.getNames(5);
        //System.out.println(names);

        NameGenerator.getNames(5)
                .subscribe(Util.onNext());



    }
}