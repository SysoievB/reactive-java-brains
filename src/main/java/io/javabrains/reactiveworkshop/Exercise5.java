package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFluxWithException;
import static io.javabrains.reactiveworkshop.ReactiveSources.userMono;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        System.out.println("Subscribe to a flux using the error and completion hooks");
        intNumbersFluxWithException().subscribe(
                data -> System.out.println(data),
                error -> System.err.println(error.getMessage()),
                () -> System.out.println("Flux completed!!!")
        );

        System.out.println("Subscribe to a flux using an implementation of BaseSubscriber");
        userMono().subscribe(new BaseSubscriber<User>(){

            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(1);
            }

            @Override
            protected void hookOnNext(User value) {
                request(1);
                System.out.println(value);
            }

            @Override
            protected void hookOnComplete() {
                System.out.println("Done!!!");
            }

            @Override
            protected void hookOnError(Throwable throwable) {
                throw new UserNotFoundException("User not found");
            }
        });

        System.out.println("Press a key to end");
        System.in.read();
    }

    private static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}