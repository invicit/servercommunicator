package Messages;

import java.io.Serializable;

public class Message implements Serializable {

    private static int idProvider = 0;
    private String sampleMessage;
    private int id;


    public Message(){
        this.id = ++idProvider;
        sampleMessage = "New message object" + id;
    }


    public String getSampleMessage() {
        return sampleMessage;
    }
}
