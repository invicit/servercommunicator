package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private ServerSocket serverSocket;
    private Socket socket;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(5566);
    }

    private void connectionEstablishing() throws IOException {
        new Thread(new ConnectionManager(serverSocket.accept())).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                connectionEstablishing();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
