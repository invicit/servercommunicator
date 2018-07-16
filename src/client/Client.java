package client;

import message.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Client {

    private static final long delay = 30000L;

    private synchronized Socket waitForServerUp() throws IOException {
        Socket s = null;
        while(true) {
            try {
                s = new Socket("127.0.0.1", 5566);
            } catch (ConnectException ignore) {}
            if (s == null) {
                new Timer(true).schedule(new TimerTask() { public void run() {timedOut();}}, delay);
                try {
                    wait();
                } catch (InterruptedException ignore) {}
            } else {
                break;
            }
        }
        return s;
    }

    private synchronized void timedOut() {
        notifyAll();
    }

    public static void main(String[] args) {
        while (true){
            Socket socket;
            Client tc = new Client();
            try {
                socket = tc.waitForServerUp();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(new Message());
                Thread.sleep(400);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
