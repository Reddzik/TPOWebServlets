package Services;

import Models.Book;

import java.util.List;
import java.util.Optional;

public class BooksServletService {
    static final Book FALLBACK_BOOK = new Book(1,"Outsider", "Stephen", "King");
    private IDbBooksService booksRepository;

    public BooksServletService(){
        this(new BooksRepository());
    }

    BooksServletService(IDbBooksService booksRepository){
        this.booksRepository=booksRepository;
    }

    public String getBooksBy(String title) {
        return prepareResponseFor(title);
    }

    public String getBooks(){
        return prepareResponseForAllBooks();
    }

    public String getBookBy(String bookId){
        return prepareResponseFor(Integer.parseInt(bookId));
    }

    private String prepareResponseFor(int bookId){
        StringBuilder resMaker = new StringBuilder();
        Book resultBook = booksRepository.findById(bookId);
        resMaker.append("\n");
            resMaker.append("<p> Tytuł: ");
            resMaker.append(resultBook.getTitle());
            resMaker.append("</p>");
            resMaker.append("<p> Autor: ");
            resMaker.append(resultBook.getAuthorName());
            resMaker.append("<span> ");
            resMaker.append(resultBook.getAuthorLastName());
            resMaker.append("</span>");
            resMaker.append("</p>");
        return resMaker.toString();
    }

    private String prepareResponseFor(String title) {
        StringBuilder resMaker = new StringBuilder();
        List<Book> resultList = booksRepository.findByTitle(title);
        resultList.forEach(b -> {
            resMaker.append("\n");
            resMaker.append("<p> Tytuł: ");
            resMaker.append(b.getTitle());
            resMaker.append("</p>");
            resMaker.append("<p> Autor: ");
            resMaker.append(b.getAuthorName());
            resMaker.append("<span> ");
            resMaker.append(b.getAuthorLastName());
            resMaker.append("</span>");
            resMaker.append("</p>");
        });
        return resMaker.toString();
    }

    private String prepareResponseForAllBooks() {
        StringBuilder resMaker = new StringBuilder();
        List<Book> books= booksRepository.getAllBooksFromDb();
        books.forEach(b->{
            resMaker.append("\n");
            resMaker.append("<p> Tytuł: ");
            resMaker.append(b.getTitle());
            resMaker.append("</p>");
            resMaker.append("<p> Autor: ");
            resMaker.append(b.getAuthorName());
            resMaker.append("<span> ");
            resMaker.append(b.getAuthorLastName());
            resMaker.append("</span>");
            resMaker.append("</p>");
            resMaker.append("<p> ======================================= </p>");
        });
        return resMaker.toString();
    }

}
