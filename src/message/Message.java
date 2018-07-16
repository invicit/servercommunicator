package message;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Message implements Serializable {
    private String message;

    public Message() {
        createMessage();
    }

    private void createMessage() {
        System.out.println("Send this message: ");
        Scanner sc = new Scanner(System.in);
        message = sc.next();
    }

    public String getMessage() {
        return message;
    }
}
