package io.javabrains.reactiveworkshop;

import lombok.val;

import java.util.stream.Collectors;

import static io.javabrains.reactiveworkshop.StreamSources.intNumbersStream;
import static io.javabrains.reactiveworkshop.StreamSources.userStream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        System.out.println("Print all numbers in the intNumbersStream stream");
        intNumbersStream().forEach(System.out::println);

        System.out.println("Print numbers from intNumbersStream that are less than 5");
        intNumbersStream()
                .filter(v -> v < 5)
                .forEach(System.out::println);

        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        intNumbersStream()
                .filter(v -> v > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("Print the first number in intNumbersStream that's greater than 5." +
                "\nIf nothing is found, print -1");
        val result = intNumbersStream()
                .filter(v -> v > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(result);

        System.out.println("Print first names of all users in userStream");
        userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);

        System.out.println("Print first names in userStream for users that have IDs from number stream");
        val firstNames = userStream()
                .filter(user -> intNumbersStream().anyMatch(number -> user.getId() == number))
                .map(User::getFirstName)
                .collect(Collectors.toList());
        firstNames.forEach(System.out::println);
    }
}
