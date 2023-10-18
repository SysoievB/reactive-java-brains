package io.javabrains.reactiveworkshop;

import lombok.val;

import java.io.IOException;
import java.util.Optional;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumberMono;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        System.out.println("Print the value from intNumberMono when it emits");
        intNumberMono().subscribe(System.out::println);

        System.out.println("Get the value from the Mono into an integer variable");
        Optional<Integer> intValue = intNumberMono().blockOptional();
        System.out.println(intValue.get());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
