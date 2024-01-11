package com.gs.rp.sec01Mono.assignment;


import com.gs.rp.courseutil.Util;

public class Lec09AssignmentDemo {

    public static void main(String[] args) {

        FileServices.read("file01.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        FileServices.write("ile03.txt","this is file 3")
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        FileServices.delete("ile03.txt")
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}