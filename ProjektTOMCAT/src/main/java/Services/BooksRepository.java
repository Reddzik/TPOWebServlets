package Services;

import Models.Book;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BooksRepository implements IDbBooksService {

     BooksRepository(){

    }
    public List<Book> findByTitle(String title){
         List<Book> matchedBooks = new ArrayList<>();
         ResultSet result = QueryExecutor.executeSelect("SELECT * FROM Book WHERE Title like '"+title+"'");
         try {
             while (result.next()) {
                 Book book = getBookFromResult(result);
                 matchedBooks.add(book);
             }
         }catch(SQLException throwables) {
             throwables.printStackTrace();
         }

        return matchedBooks==null?Collections.EMPTY_LIST:matchedBooks;
    }

    public Book findById(int id) {
        Book book= null;
        ResultSet result = QueryExecutor.executeSelect("SELECT * FROM Book WHERE BookId="+id);
        try {
            result.next();
            book = getBookFromResult(result);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

    public List<Book> getAllBooksFromDb(){
         List<Book> books = new ArrayList<>();
         ResultSet result= QueryExecutor.executeSelect("SELECT * FROM Book");
        try {
            while(result.next()) {
                Book book = getBookFromResult(result);
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    private Book getBookFromResult(ResultSet result) throws SQLException {
        ResultSet authorResult = getAuthorResultSet(result);
        Book book = new Book(result.getInt(result.findColumn("BookId")),
                 result.getString("Title"),
                 authorResult.getString("FirstName"),
                 authorResult.getString("LastName"));
         return book;
    }

    private ResultSet getAuthorResultSet(ResultSet result) throws SQLException {
        int AuthorId = result.getInt(result.findColumn("AuthorId"));
        ResultSet authorResultSet = QueryExecutor.executeSelect(
                "Select * From Author where AuthorId = "+AuthorId);
        authorResultSet.next();
        return authorResultSet;
    }


}
