package Services;

import Models.Book;

import java.util.Optional;

public class BooksServletService {
    static final Book FALLBACK_BOOK = new Book(1,"Kordian", "Juliusz Słowacki");
    private IDbBooksService booksRepository;

    public BooksServletService(){
        this(new BooksRepository());
    }

    BooksServletService(IDbBooksService booksRepository){
        this.booksRepository=booksRepository;
    }

    public Book prepareBookBy(String title) {
        Book book = getBookFromRepository(title);
        return book;
    }

    private Book getBookFromRepository(String title) {
        String bookTitle = Optional.ofNullable(title).orElse(FALLBACK_BOOK.getTitle());
        return booksRepository.findByTitle(bookTitle).orElse(FALLBACK_BOOK);
    }

}
