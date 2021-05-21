package servlet;

import bean.Book;
import dao.bookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class editBookServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        Book book=new Book();
        book=new bookDAO().get(id);
        String bid=String.valueOf(id);
        String name=book.name;
        String kind=book.kind;
        String time=book.time;
        request.setAttribute("bid",bid);
        request.setAttribute("name",name);
        request.setAttribute("kind",kind);
        request.setAttribute("time",time);
        request.getRequestDispatcher("updateBook.jsp").forward(request,response);
    }
}
