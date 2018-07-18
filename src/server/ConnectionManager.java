package server;

import message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ConnectionManager implements Runnable {
    private Socket accept;


    ConnectionManager(Socket accept) {
        this.accept = accept;
    }

    private Message getMessage() throws IOException, ClassNotFoundException {

        ObjectInputStream inStream = new ObjectInputStream(accept.getInputStream());
        Message message = (Message) inStream.readObject();

        System.out.println(message.getMessage());

        return message;

    }

    @Override
    public void run() {
        while(true){
            try {
                getMessage();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        //TODO get user id, querry to UserManager about existing in DB
        //TODO creating a User instance with name and socket parameters;
    }
}
