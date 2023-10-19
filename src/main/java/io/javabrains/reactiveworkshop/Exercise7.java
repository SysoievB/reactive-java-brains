package io.javabrains.reactiveworkshop;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;
import static io.javabrains.reactiveworkshop.ReactiveSources.userFlux;

public class Exercise7 {

    public static void main(String[] args) throws IOException {

        System.out.println("Print all values from intNumbersFlux that's greater than 5");
        // intNumbersFlux().filter(number -> number > 5).subscribe(System.out::println);

        System.out.println("Print 10 times each value from intNumbersFlux that's greater than 5");
        // intNumbersFlux().filter(num -> num > 5).repeat(10).subscribe(System.out::println);

        System.out.println("Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5");
        // intNumbersFlux().filter(num -> num > 5).take(3).repeat(10).subscribe(System.out::println);

        System.out.println("Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found");
        //intNumbersFlux().filter(num -> num > 20).defaultIfEmpty(-1).subscribe(System.out::println);

        System.out.println("Switch ints from intNumbersFlux to the right user from userFlux");
        intNumbersFlux().flatMap(number -> userFlux().filter(user -> user.getId() == number)).subscribe(System.out::println);

        System.out.println("Print only distinct numbers from intNumbersFluxWithRepeat");
        //intNumbersFluxWithRepeat().distinct().subscribe(System.out::println);

        System.out.println("Print from intNumbersFluxWithRepeat excluding immediately repeating numbers");
        //intNumbersFluxWithRepeat().distinctUntilChanged().subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
