import java.io.IOException;

//ConnectionManager reads Message objects from socket input stream

public class Main {
    public static void main(String[] args) {
        try {
            new Thread(Server.SingletonHelper.getInstance()).start();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("AAA");
        }
    }
}