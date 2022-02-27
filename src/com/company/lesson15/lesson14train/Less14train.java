package com.company.lesson15.lesson14train;

import com.company.lesson15.lesson14train.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Less14train {

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            integerList.add(getInt(100,1000));
        }
        integerList.stream()
                .filter(x -> x != 0 && x % 2 ==0)
                .flatMap(age -> Stream.of(new Client(1,"Alex", age)))
                .forEach(System.out::println);


        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 50; i++)
            if (i % 2 == 0)
                stringList.add("asd" + i);
            else
                stringList.add("asdf" + i);
       stringList.stream()
                .map(String::toUpperCase)
                .sorted()
                .filter(element -> element.length() == 5)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Exception")
                );
//        String firstElement = optional.get();
//        System.out.println(firstElement);


    }
    private static int getInt(int from, int to) {
        return RANDOM.nextInt(to - from) + from;
    }
}

