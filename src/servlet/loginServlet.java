package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class loginServlet extends HttpServlet {
    protected void service(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException {
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/webbigexp?characterEncoding=UTF-8","root","123456");
            String sql="select * from `user` where id=? and password=?";
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                request.getSession().setAttribute("user",id);
                response.sendRedirect("listBook");
            }
            else
                response.sendRedirect("failLogin.html");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
