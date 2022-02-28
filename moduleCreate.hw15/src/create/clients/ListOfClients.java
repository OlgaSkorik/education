package create.clients;

import java.util.List;

public class ListOfClients {
    public static List<Clients> getList() {
        return List.of(new Clients("Alex", 35,"teacher"),
                new Clients("Nic", 53, "president"),
                new Clients("Den", 41, "judge"));
    }
}