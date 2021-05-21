package servlet;

import bean.Book;
import dao.bookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateBookServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String kind=request.getParameter("kind");
        String time=request.getParameter("time");
        Book book=new Book();
        book.id=id;
        book.name=name;
        book.kind=kind;
        book.time=time;
        new bookDAO().update(book);
        response.sendRedirect("listBook");
    }
}
