package lesson5;

public class Book {
    // свойства, поля, атрибуты
    // название книг
    private String title; // null по-умолчанию для ссылочных типов
    private String author;

    private boolean isForHome; // false по-умолчанию для Boolean
    private boolean isAvailable;

    // конструкторы
    public Book(){}

    public Book(String title, String author){
        setTitle(title);
        setAuthor(author);
    }

    public Book(String title){
        setTitle(title);
    }

    // методы, устанавливающие значения свойства title и author
    public void setTitle(String title){
        // this - ссылка на текущий объект
        if (title != null && !"".equals(title)){
            this.title = title;
        } else {
        }
    }

    // alt + insert
    public void setAuthor(String author) {
        if (author != null && !"".equals(author)){
            this.author = author;
        } else {
        }
    }

    public void setForHome(boolean forHome) {
        isForHome = forHome;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
// методы, которые возвращают значения свойств (геттеры)

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getForHome() {
        return isForHome;
    }

    public boolean getAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isForHome=" + isForHome +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
