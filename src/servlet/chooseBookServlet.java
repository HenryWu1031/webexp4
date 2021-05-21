package servlet;

import bean.Book;
import dao.bookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class chooseBookServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        String way=request.getParameter("way");
        String info=request.getParameter("info");
        if (way.equals("ID")){
            int id=Integer.parseInt(info);
            ArrayList<Book> choosebooks=new bookDAO().selectById(id);
            request.setAttribute("choosebooks",choosebooks);
            request.getRequestDispatcher("chooseBook.jsp").forward(request,response);
        }else if(way.equals("名称")){
            ArrayList<Book> choosebooks=new bookDAO().selectByName(info);
            request.setAttribute("choosebooks",choosebooks);
            request.getRequestDispatcher("chooseBook.jsp").forward(request,response);
        }else if(way.equals("类别")){
            ArrayList<Book> choosebooks=new bookDAO().selectByKind(info);
            request.setAttribute("choosebooks",choosebooks);
            request.getRequestDispatcher("chooseBook.jsp").forward(request,response);
        }else if(way.equals("具体入库时间")){
            ArrayList<Book> choosebooks=new bookDAO().selectByTime(info);
            request.setAttribute("choosebooks",choosebooks);
            request.getRequestDispatcher("chooseBook.jsp").forward(request,response);
        }
    }
}
