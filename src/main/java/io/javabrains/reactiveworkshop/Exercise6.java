package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;
import java.time.Duration;

import static io.javabrains.reactiveworkshop.ReactiveSources.unresponsiveFlux;
import static io.javabrains.reactiveworkshop.ReactiveSources.unresponsiveMono;

public class Exercise6 {

    public static void main(String[] args) throws IOException {

        System.out.println("Get the value from the Mono into a String variable but give up after 5 seconds");
        unresponsiveMono().delayElement(Duration.ofSeconds(5)).subscribe(
                data -> System.out.println(data),
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("Flux completed!!!")
        );

        System.out.println("Get the value from unresponsiveFlux into a String list but give up after 5 seconds\n" +
                "Come back and do this when you've learnt about operators!");
        unresponsiveFlux().collectList().delaySubscription(Duration.ofSeconds(5)).subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
