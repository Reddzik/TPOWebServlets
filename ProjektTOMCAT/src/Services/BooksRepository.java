package Services;

import Models.Book;

import java.util.*;

public class BooksRepository implements IDbBooksService {
    private Collection<Book> books;

     BooksRepository(){
        books = new ArrayList<>();
        books.add(new Book(1,"Konrad Walendrod", "Adam Mickiewicz"));
        books.add(new Book(2, "Ferdydurke", "Witold Gombrowicz"));
    }
    public Optional<Book> findByTitle(String title){
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst();
    }

    @Override
    public Optional<Book> findById(int id) {
        return Optional.empty();
    }

}
