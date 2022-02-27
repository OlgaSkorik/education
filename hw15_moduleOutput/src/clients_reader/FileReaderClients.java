package clients_reader;

import create_clients.Clients;

import java.io.*;
import java.util.*;

public class FileReaderClients {

    public static void main(String[] args) {
        List<Clients> newList = new ArrayList<>();
        try (var objectReader = new ObjectInputStream(new FileInputStream("./hw15.listOfClients.txt"))) {
            while (true) {
                newList.add((Clients) objectReader.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
                    e.getCause();
                }
                newList
                        .forEach(System.out::println);
    }
}
