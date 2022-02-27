package lesson.produser.file_writer;

import com.company.lesson15.lesson.produser.Produser;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {

    public static void main (String[] args) throws IOException {

        try (var writer = new BufferedWriter(new java.io.FileWriter("./test.txt"))) {
            Produser.getList().stream()
                    .forEach(str -> {
                        try {
                            writer.write(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
