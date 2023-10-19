package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFluxWithException;

public class Exercise8 {

    public static void main(String[] args) throws IOException {

        System.out.println("Print values from intNumbersFluxWithException and print a message when error happens");
        intNumbersFluxWithException().subscribe(
                value -> System.out.println(value),
                error -> System.out.println("Error happened")
        );

          intNumbersFluxWithException()
                .doOnError(error -> System.out.println("Error happened"))
                .subscribe(value -> System.out.println(value));

        System.out.println("Print values from intNumbersFluxWithException and continue on errors" +
                "\nPrint values from intNumbersFluxWithException and print a message when error happens");
        intNumbersFluxWithException()
                .onErrorContinue((error, item) -> System.out.println("Error happened with message: " + error.getMessage()))
                .subscribe(value -> System.out.println(value));

        System.out.println("Print values from intNumbersFluxWithException and when errors" +
        "\nhappen, replace with a fallback sequence of -1 and -2");
        intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(value -> System.out.println(value));

        System.out.println("Press a key to end");
        System.in.read();
    }
}
