import Messages.Message;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ConnectionManager implements Runnable{

    UserManager userManager;
    List<UserToUserConnection> userToUserConnectionList;
    Socket accept;


    ConnectionManager(Socket accept){
        this.accept = accept;
    }

    private Message getMessage() throws IOException, ClassNotFoundException {

        ObjectInputStream inStream = new ObjectInputStream(accept.getInputStream());
        Message message = (Message) inStream.readObject();


        System.out.println(message.getSampleMessage());


        return message;

    }




    @Override
    public void run() {
        while(true){
        try {
            //getMessage().getSampleMessage();
            getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }}
        //TODO get user id, querry to UserManager about existing in DB
        //TODO creating a User instance with name and socket parameters;
    }
}
