package december.december_16th.task;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Library {
    /*В библиотеке доступно несколько разных! книг.
    (некоторые только для читального зала, некоторые можно взять домой).
    Читатель может брать несколько книг за один раз. (ЗАДАЧА НА БЛОКИРУЮЩИЕ ОЧЕРЕДИ: когда будет вызывать take() то сделать взятие рандомного количества книг, по одной или по несколько)
    [book1, book2, book3, book4, book5] : take() / put()
    reader 1 reader 2 reader 3 reader 4*/
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Война и мир", true));
        books.add(new Book("Над пропастью во ржи", false));
        books.add(new Book("Пролетая над гнездом кукушки", true));
        books.add(new Book("Карлсон", false));
        books.add(new Book("Библия", true));
        books.add(new Book("Мы были солдатами", false));
        books.add(new Book("Трактат о чем-то", true));
        books.add(new Book("Энциклопедия", false));
        books.add(new Book("Мемуары Наполеона", true));
        books.add(new Book("Капитал", false));
        ArrayList<Reader> readers = new ArrayList<>();
        LinkedBlockingDeque<Book> queueToReadInside = new LinkedBlockingDeque<>(5);
        LinkedBlockingDeque<Book> queueToTakeHome = new LinkedBlockingDeque<>(5);
        readers.add(new Reader("Свидригайло", queueToReadInside, queueToTakeHome));
        readers.add(new Reader("Цукерберг", queueToReadInside, queueToTakeHome));
        readers.add(new Reader("Григоращенко", queueToReadInside, queueToTakeHome));
        readers.add(new Reader("Иванов", queueToReadInside, queueToTakeHome));
        readers.add(new Reader("Персидский", queueToReadInside, queueToTakeHome));
        readers.add(new Reader("Сидоров", queueToReadInside, queueToTakeHome));
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isToReadInsideOnly()) {
                queueToReadInside.put(books.get(i));
            } else {
                queueToTakeHome.put(books.get(i));
            }
        }
        for (int i = 0; i < readers.size(); i++) {
            new Thread(readers.get(i)).start();
        }
    }

}

class Reader implements Runnable {
    private String name;
    private LinkedBlockingDeque<Book> queueToReadInside;
    private LinkedBlockingDeque<Book> queueToTakeHome;

    public Reader(String name, LinkedBlockingDeque<Book> queueToReadInside, LinkedBlockingDeque<Book> queueToTakeHome) {
        this.name = name;
        this.queueToReadInside = queueToReadInside;
        this.queueToTakeHome = queueToTakeHome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void run() {
        Random random = new Random();
        Book bookIsTaken;
        boolean toReadInside = random.nextBoolean();
        while (true) {
            try {
                Thread.sleep((random.nextInt(15) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                bookIsTaken = (toReadInside) ? queueToReadInside.take() : queueToTakeHome.take();
            } catch (InterruptedException e) {
                continue;
            }
            if (toReadInside)
                System.out.println(this.getName() + " взял книгу " + bookIsTaken.getName() + " и сел читать ее в зале");
            else System.out.println(this.getName() + " взял книгу " + bookIsTaken.getName() + " и унес ее домой");
            try {
                Thread.sleep((random.nextInt(15) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (toReadInside) queueToReadInside.put(bookIsTaken);
                else queueToTakeHome.put(bookIsTaken);
                System.out.println(this.getName() + " вернул книгу " + bookIsTaken.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Book {
    private String name;
    private boolean toReadInsideOnly;

    public Book(String name, boolean toReadInsideOnly) {
        this.name = name;
        this.toReadInsideOnly = toReadInsideOnly;
    }

    public boolean isToReadInsideOnly() {
        return toReadInsideOnly;
    }

    public void setToReadInsideOnly(boolean toReadInsideOnly) {
        this.toReadInsideOnly = toReadInsideOnly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}