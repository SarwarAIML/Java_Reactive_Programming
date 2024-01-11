package com.gs.rp.courseutil;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

import static java.lang.Thread.*;

public  class Util {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received : "+o);
    }

    public static Consumer<Throwable> onError(){
        return err -> System.out.println("ERROR : "+ err.getMessage());
    }

    public static Runnable onComplete(){
        return () ->System.out.println("Completed");
    }

    public static Faker faker(){
        return FAKER;
    }

    public static  void sleepSecond(int seconds){
        try {
            sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static  void sleepMillis(int millisecond){
        try {
            sleep(millisecond );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Subscriber<Object> subscriber(){
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name){
        return new DefaultSubscriber(name);
    }
}