package Services;

import Models.Book;

import java.util.List;
import java.util.Optional;

public interface IDbBooksService {
    List<Book> findByTitle(String title);
    Book findById(int id);
    List<Book> getAllBooksFromDb();
}
