package Servlets;

import Services.BooksServletService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Hello", urlPatterns = {"/api/book"})
public class BooksServlet extends HttpServlet {
    private static final String BOOK_NAME_PARAM = "name";
    private static final String BOOK_ID_PARAM = "id";
    private BooksServletService service;

    /**
     * Servlet container use it
//     */
    public BooksServlet(){
        this(new BooksServletService());
    }

    BooksServlet(BooksServletService booksServletService){
        this.service = booksServletService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        configureResponse(resp);
        String bookName = req.getParameter(BOOK_NAME_PARAM);
        String bookId = req.getParameter(BOOK_ID_PARAM);
        PrintWriter writer = resp.getWriter();
        if(bookName!=null){
            writer.write(service.getBooksBy(bookName));
        }
        else if(bookId!=null){
            writer.write(service.getBookBy(bookId));
        }
        else {
            writer.write(service.getBooks());
        }

        writer.println(
                "<form action=\"" + resp.encodeURL("/web_war_exploded/") +
                        "\" method=\"post\">" +
                        "<td><input type=\"submit\"value=\"Wróć na stronę główną\"></td>" +
                        "</form>");
        writer.close();
    }

    private void configureResponse(HttpServletResponse resp) {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
    }
}
