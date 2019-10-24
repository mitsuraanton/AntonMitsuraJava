package lesson5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book java = new Book();
        Book cleanCode = new Book();

//        java.title = "Философия Java";
//        cleanCode.title = "Чистый код";
//        java.author = "Брюс Эккель";
//        cleanCode.author = "Роберт Мартин";

        java.setTitle("Философия джава");
        cleanCode.setTitle("Чистый код");
        java.setAuthor("Брюс Эккель");
        cleanCode.setAuthor("Роберт Мартин");
        java.setForHome(true);
        java.setAvailable(true);
        cleanCode.setAvailable(true);
        Book forBegginers = new Book("Руководство для начинающих", "Герберт Шилдт");
        Library library = new Library();
        library.addBook(java);
        library.addBook(cleanCode, forBegginers);

        Scanner in = new Scanner(System.in);
        System.out.println("Введите название книги:");
        String inputBookName = in.nextLine();



    }
}
