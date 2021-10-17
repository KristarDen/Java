package step.library;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddBookServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletResponse response;
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();


        String id = req.getParameter("id");
        String author = req.getParameter("author");
        String title = req.getParameter("title");
        String cover = req.getParameter("cover");

        writer.println(
                "id: "+ id +
                ", author : " + author +
                ", title : " + title +
                ", cover : " + cover
        );

    }
}
