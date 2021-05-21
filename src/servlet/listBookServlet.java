package servlet;

import bean.Book;
import dao.bookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class listBookServlet extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int start=0;
        int count=7;
        try {
            start=Integer.parseInt(request.getParameter("start"));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        bookDAO bookdao=new bookDAO();
        int total=bookdao.getTotal();
        int pre=start-7;
        int next=start+7;
        int last;
        if(total%7==0)
            last=total-7;
        else
            last=total-(total%7);
        pre= pre<0 ? 0:pre ;
        next=next>last ? last:next;
        ArrayList<Book> books=bookdao.list(start,count);
        request.setAttribute("books",books);
        request.setAttribute("pre",pre);
        request.setAttribute("next",next);
        request.setAttribute("last",last);
        request.getRequestDispatcher("listBook.jsp").forward(request,response);
    }
}
