package clients_writing;

import create_clients.ListOfClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriterClients {

    public static void main (String[] args) throws IOException {
        try (var objectWriter = new ObjectOutputStream(new FileOutputStream("./hw15.listOfClients.txt"))) {
            ListOfClients.getList()
                    .forEach(client -> {
                        try {
                            objectWriter.writeObject(client);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
