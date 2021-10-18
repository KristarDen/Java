package step.library.servlets;

import step.library.models.Book;
import step.library.utils.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditBook extends HttpServlet {

    private String _id = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        _id = id;
        Book book = Db.getBookOrm().getBook(id);
        req.setAttribute("name", book.getTitle());
        req.setAttribute("author", book.getAuthor());

        getServletContext().getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = req.getParameter("author" );
        String title = req.getParameter("title" );
        Db.getBookOrm().updateBook( _id,author, title );
    }
}
