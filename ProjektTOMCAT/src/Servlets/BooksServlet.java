package Servlets;

import Services.BooksServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BooksServlet extends HttpServlet {
    private static final String BOOK_NAME_PARAM = "name";
    private BooksServletService service;

    /**
     * Servlet container use it
     */
    BooksServlet(){
        this(new BooksServletService());
    }

    BooksServlet(BooksServletService booksServletService){
        this.service = booksServletService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter(BOOK_NAME_PARAM);
        resp.getWriter().write(bookName);
    }
}
