package december.december_11th.homeWorkClientServer.realization;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;

// ЗАДАЧКА: ОДИН КЛИЕНТ ОТПРАВЛЯЕТ СООБЩЕНИЕ НА СЕРВЕР. СЕРВЕР ПОЛУЧАЕТ ЕГО И ОТСЫЛАЕТ ЕГО ВСЕМ ОСТАЛЬНЫМ КЛИЕНТАМ, КРОМЕ ОТПРАВИТЕЛЯ
// В СООБЩЕНИИ ДОЛЖЕН ПЕРЕДАТЬ ОТ КОГО И ВО СКОЛЬКО
// СОЕДИНЕНИЕ НАДО СОХРАНЯТЬ НА СЕРВЕРЕ. КОГДА КЛИЕНТ ОТКЛЮЧАЕТСЯ, ТО НУЖНО УДАЛЯТЬ СОЕДИНЕНИЕ ИЗ ХРАНИЛИЩА И НА СЕРВЕРЕ ВЫВОДИМ ИНФОРМАЦИЮ, ЧТО ОТКЛЮЧИЛСЯ ТАКОЙ-ТО КЛИЕНТ
// Client: main поток, в нем считываем информацию с консоли (сообщение, которое надо отправить) и отправляем на сервер
// Во втором потоке на клиенте мы сообщения читаем: те, которые приходят с сервера
// Дать возможность клиенту выйти
// В клиенте поток reader, который будет читать сообщения от сервера
// Server поток: writer -- пишущий поток. Он занимается отправкой сообщений клиентам.
// Reader потоки читают сообщения от клиентов, на каждое соединени свой поток. Когда клиент подключается, то его создаем и в нем читаем сообщение от клиента
// LinkedBlockingDeque -- это дял хранения сообщенийъ
// Для хранения соединений проще всего использовать мапу
// Message (сериализуем и передаем): в мессадже -- отправитель, текст сообщения, дата и время
// создаем сервер. НА клиенте создаем сокет, который кодключается по ай пи и порту
// Сервер ждет входящих подключений
// На сервере воссоздается клиентский сокет
// В 14 УРОКЕ ЕСТЬ СОКЕТЫ!!!!!!!!!!!!!!!!!!!
// Server: ServerSocket serverSocket = ...
// Селекторов не должно быть. Из 14 урока все брать.
public class MessageServer {

    public static void main(String[] args) throws IOException {
        // СЕРВЕР СОКЕТ ДОЛЖЕН БЫТЬ ОБЩИЙ ДЛЯ РИДЕРА И ДЛЯ СЕНДЕРА
        LinkedBlockingDeque<Message> queue = new LinkedBlockingDeque();
        HashMap<Connection, String> connections = new HashMap<>();
        new Thread(new ConnectionsCreator(connections)).start();
        new Thread(new Reader(queue, connections)).start();
        new Thread(new Sender(queue, connections)).start();
    }

    private static class ConnectionsCreator implements Runnable {
        ServerSocket serverSocket;
        private HashMap<Connection, String> connections;

        public ConnectionsCreator(HashMap<Connection, String> connections) throws IOException {
            this.serverSocket = new ServerSocket(12345);
            this.connections = connections;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // СОЗДАТЬ СПИСОК ИЗ МАК КОННЕКШЕНОВ. В МАПЕ ИМЯ КЛИЕНТА И ЕГО КОННЕКШЕН. ДАЛЬШЕ ОТПРАВЛЯТЬ СЕССАГУ ТОЛЬКО ТЕМ, КОМУ НАДО
                    Connection connection = new Connection(serverSocket.accept());
                    connections.put(connection, null);
                } catch (IOException e) {
                    Thread.yield();
                }
                Thread.yield();
            }
        }
    }

    private static class Reader implements Runnable {
        private LinkedBlockingDeque<Message> queue;
        private HashMap<Connection, String> connections;

        private Reader(LinkedBlockingDeque<Message> queue, HashMap<Connection, String> connections) {
            this.queue = queue;
            this.connections = connections;
        }

        @Override
        public void run() {
            while (true) {
                // СОЗДАТЬ СПИСОК ИЗ МАК КОННЕКШЕНОВ. В МАПЕ ИМЯ КЛИЕНТА И ЕГО КОННЕКШЕН. ДАЛЬШЕ ОТПРАВЛЯТЬ СЕССАГУ ТОЛЬКО ТЕМ, КОМУ НАДО
                for (Connection connection : connections.keySet()) {
                    try {
                        Message message = connection.readMessage();
                        System.out.println("От клиента " + message.getSender() + " пришло сообщение:");
                        System.out.println(message.getText());
                        connections.put(connection, message.getSender());
                        queue.put(message);
                    } catch (IOException | ClassNotFoundException | InterruptedException e) {
                        Thread.yield();
                    }
                    Thread.yield();
                }
                Thread.yield();
            }
        }
    }

    private static class Sender implements Runnable {
        private LinkedBlockingDeque<Message> queue;
        private HashMap<Connection, String> connections;

        private Sender(LinkedBlockingDeque<Message> queue, HashMap<Connection, String> connections) {
            this.queue = queue;
            this.connections = connections;
        }

        @Override
        public void run() {
            Message message;
            while (true) {
                // СОЗДАТЬ СПИСОК ИЗ МАК КОННЕКШЕНОВ. В МАПЕ ИМЯ КЛИЕНТА И ЕГО КОННЕКШЕН. ДАЛЬШЕ ОТПРАВЛЯТЬ СЕССАГУ ТОЛЬКО ТЕМ, КОМУ НАДО
                try {
                    message = queue.take();
                    for (Connection connection : connections.keySet()) {
                        try {
                            if (!message.getSender().equals(connections.get(connection))) {
                                System.out.println("Сервер отправляет сообщение: " + message.getText());
                                connection.sendMessage(message);
                            }
                        } catch (IOException e) {
                            Thread.yield();
                        }
                        Thread.yield();
                    }
                    Thread.yield();
                } catch (InterruptedException e) {
                    Thread.yield();
                }

            }
        }
    }
}
