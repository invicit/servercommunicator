import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable {

   // RequestHandler requestHandler;
    DataBaseManager dbManager;
    ServerSocket serverSocket;
    ConnectionManager connectionManager;

    private Server() throws IOException {
        this.serverSocket = new ServerSocket(5678);
   //     this.requestHandler = new RequestHandler();
        this.dbManager = new DataBaseManager();
        this.connectionManager = new ConnectionManager(serverSocket.accept());
    }


    public void connectionEstablishing() throws IOException {
        new Thread(new ConnectionManager(serverSocket.accept())).start();
    }

    @Override
    public void run() {
        while (true){
            try {
                connectionEstablishing();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static class SingletonHelper{
        private static Server INSTANCE = null;


        public static Server getInstance() throws IOException {
            if(INSTANCE == null){
                INSTANCE  = new Server();
            }

            return INSTANCE;
        }
    }





}
