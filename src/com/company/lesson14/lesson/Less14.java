package com.company.lesson14.lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Less14 {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>() {{
            add("1");
            add("2");
            add("3");
        }};
        list.forEach(System.out::println);

        Consumer<String> consumer = element -> System.out.println(element);
        consumer.accept("Consumer");

        Predicate<Integer> predicate = number -> number > 10;
        System.out.println(predicate.test(12));

        BinaryOperator<Integer> binaryOperator = (first, second) -> first + second;
        System.out.println(binaryOperator.apply(2,3));

        UnaryOperator<Integer> unaryOperator = number -> number * number;
        System.out.println(unaryOperator.apply(3));

        Function<Integer,String> function = number -> number + " y.e.";
        System.out.println(function.apply(100));

        //Stream

        int[] ints = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
        int count = 0;
        for (int element : ints)
            if (element >0)
                count++;
        System.out.println(count);

        Stream<Integer> integerStream = Stream.of(-5,-4,-3,-2,-1,0,1,2,3,4,5);
        long streamCount = integerStream.filter(element -> element > 0).count();
        System.out.println(streamCount);

        List<Client> clients = new ArrayList<>();
        clients.add(new Client(87,"Alex", 2000));
        clients.add(new Client(12,"Andrey", 3000));
        clients.add(new Client(43,"Anton", 1000));
        clients.add(new Client(32,"Kirill", 5000));
        clients.add(new Client(58,"Ivan", 10000));

        clients.stream()
                .map(Client::getSalary)
                .filter(salary -> salary > 1000)
                .forEach(System.out::println);

        List<Client> clientAge20 = clients.stream()
                .filter(client -> client.getAge() > 20)
                .collect(Collectors.toList());
        clientAge20.forEach(System.out::println);
        System.out.println();
        clients.stream().forEach(System.out::println);
        System.out.println();
        //clients.stream().sorted().forEach(System.out::println);
        clients.stream()
                .sorted((currentElement, nextElement) -> currentElement.getAge() - nextElement.getAge())
                .forEach(System.out::println);

        Optional<String> optional = Optional.of(null);
        optional.get().length();
    }
}

class Client implements Comparable<Client>{
    private int age;
    private String name;
    private int salary;

    public Client(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Client{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Client o) {
        return this.age - o.getAge();
    }
}
