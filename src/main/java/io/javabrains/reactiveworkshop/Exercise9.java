package io.javabrains.reactiveworkshop;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;

public class Exercise9 {

    public static void main(String[] args) throws IOException {

        System.out.println("Print size of intNumbersFlux after the last item returns");
        intNumbersFlux().count().subscribe(System.out::println);

        System.out.println("Collect all items of intNumbersFlux into a single list and print it");
        intNumbersFlux().collectList().subscribe(System.out::println);

        System.out.println("Transform to a sequence of sums of adjacent two numbers");
        intNumbersFlux().buffer(2).map(list -> list.get(0) + list.get(1)).subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
