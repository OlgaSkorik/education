package clients.reader;

import create.clients.Clients;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileReaderClients {

    public static void main(String[] args) {
        List<Clients> newList = new ArrayList<>();
        try (var objectReader = new ObjectInputStream(new FileInputStream("./hw15.listOfClients.txt"))) {
            while (true) {
                newList.add((Clients) objectReader.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.toString();
        }
        newList
                .forEach(System.out::println);
    }
}
