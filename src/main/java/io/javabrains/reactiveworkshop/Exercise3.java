package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        System.out.println("Get all numbers in the ReactiveSources.intNumbersFlux stream" +
                "\ninto a List and print the list and its size");
        List<Integer> list = intNumbersFlux().toStream().toList();
        list.forEach(values -> System.out.println("The list is: " + values.toString()));
        System.out.println("The size of the list is: " + list.size());

        System.out.println("Press a key to end");
        System.in.read();
    }
}
