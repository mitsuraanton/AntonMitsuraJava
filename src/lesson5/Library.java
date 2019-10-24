package lesson5;

public class Library {
    private Book[] books = new Book[10];

    // в библиотеку можно добавить одну кнгигу
    public void addBook(Book newBook){
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null){
                books[i] = newBook;
                return;
            }
        }
    }

    // в библиотеку можно добавить сразу несколько книг
    public void addBook(Book ...newBooks){
        for (int i = 0; i < newBooks.length; i++) {
            for (int j = 0; j < books.length; j++) {
                if (books[j] == null){
                    books[j] = newBooks[i];
                    break;
                }
            }
        }
    }

    // должна быть возможность получить информацию по книге, указав ее название (получаемая информация:автор, название, можно ли забрать домой, доступна ли книга)
    // если нкнига не найдена, сообщаем, что такой книги нет
    // Найдена книга:
    // Если недоступна - то написать, что недоступна
    // Если выдана, то написать, что уже выдана
    public String getInfo(String title){
        for (int i = 0; books[i] != null; i++) {
            if (books[i].getAuthor().equals(title)){
                String bookInfo = "Книга найдена. Название: " + books[i].getTitle() + ". Автор: " + books[i].getAuthor() + ". Доступна в читальном зале/для выдачи на дом. Для выдачи доступна/пока недоступна";
                bookInfo = books[i].getForHome() ? bookInfo + " Для выдачи на дом." : bookInfo + " Доступна в читальном зале.";
                bookInfo = books[i].getAvailable() ? bookInfo + " Для выдачи доступна." : bookInfo + " Для выдачи пока доступна.";
                return bookInfo;
            }
        }
        System.out.println("Книга не найдена");
        return null;
    }

//    Должна быть возможность взять книгу на дом, указав название
//    Должна быть возможность почитать книгу в читальном зале, указав название.
    // Книги, с указанным названием в библиотеке может не быть
    public Book takeHome(String title){
        for (int i = 0; books[i] != null; i++) {
            if (books[i].getAuthor().equals(title)){
                if (books[i].getAvailable() && books[i].getForHome()){
                    books[i].setAvailable(false);
                    return books[i];
                } else if (books[i].getAvailable() && !books[i].getForHome()){
                    System.out.println("Книгу нельзя взять на дом. Она только для читального зала");
                    return null;
                } else {
                    System.out.println("Книга уже выдана. К выдаче сейчас недоступна.");
                    return null;
                }
            }
        }
        System.out.println("Книга не найдена");
        return null;
    }


    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
