package com.company.lesson14.homework;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HomeWork {

    public static void main(String[] args) {

        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Audi",2019,60000));
        carList.add(new Car("Volkswagen",2022,45000));
        carList.add(new Car("Bentley",2020,100000));

        carList.stream()
                .sorted((element, nextElement) -> element.getPrice() - nextElement.getPrice())
                .forEach(System.out::println);



        Stream<String> stream = Stream.of("Level ", "java", "noon", "pen", "dad");
        stream.filter(element -> element.trim().equalsIgnoreCase(new StringBuilder(element.trim())
                .reverse().toString()))
                .forEach(System.out::println);

    }
}

class Car {
    private String brand;
    private int carYear;
    private int price;


    public Car(String brand, int carYear, int price) {
        this.brand = brand;
        this.carYear = carYear;
        this.price = price;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", carYear=" + carYear +
                ", price=" + price +
                '}';
    }
}
