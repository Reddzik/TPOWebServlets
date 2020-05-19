package Services;

import Models.Book;

import java.util.Optional;

public interface IDbBooksService {
    Optional<Book> findByTitle(String title);
    Optional<Book> findById(int id);
}
