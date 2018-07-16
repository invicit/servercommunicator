import server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server server;
        try {
            server = new Server();
            new Thread(server).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
