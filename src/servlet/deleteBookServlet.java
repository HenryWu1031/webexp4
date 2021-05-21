package servlet;

import dao.bookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteBookServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        new bookDAO().delete(id);
        response.sendRedirect("listBook");
    }
}
