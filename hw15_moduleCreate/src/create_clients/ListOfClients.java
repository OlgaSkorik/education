package create_clients;

import java.io.Serializable;
import java.util.List;

public class ListOfClients implements Serializable {
    public static List<Clients> getList() {
        return List.of(new Clients("Alex", 25,"teacher"),
                new Clients("Nic", 53, "president"),
                new Clients("Den", 41, "judge"));
    }
}