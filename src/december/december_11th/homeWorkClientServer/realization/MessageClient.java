package december.december_11th.homeWorkClientServer.realization;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MessageClient {

    public static void main(String[] args) throws IOException {
        Connection connection = new Connection(new Socket("localhost", 12345));
        new Thread(new Reader(connection)).start();
    }

    public static class Reader implements Runnable {
        private Connection connection;


        public Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            Thread.currentThread().setPriority(9);
            try {
                new Thread(new Sender("Client 4", connection)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    Message message = connection.readMessage();
                    System.out.println("От сервера пришло сообщение:");
                    System.out.println(message.getText());
                } catch (IOException | ClassNotFoundException e) {
                    Thread.yield();
                }
                Thread.yield();
            }
        }
    }

    public static class Sender implements Runnable {
        private Scanner scanner;
        private String name;
        private Connection connection;

        public Sender(String name, Connection connection) throws IOException {
            this.name = name;
            this.connection = connection;
            scanner = new Scanner(System.in);
        }

        @Override
        public void run() {
            Thread.currentThread().setPriority(10);
            while (true) {
                try {
                    System.out.println("Введите сообщение для отправки на сервер");
                    Thread.yield();
                    connection.sendMessage(new Message(name, scanner.nextLine(), 12345));
                    Thread.yield();
                } catch (IOException e) {
                    Thread.yield();
                }
                Thread.yield();
            }
        }
    }
}


