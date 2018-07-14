import Messages.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class BasicClientClass {


    public static void main(String[] args) {
        while (true){
            try {
                Socket socket = new Socket("localhost", 5678);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(new Message());



            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


}