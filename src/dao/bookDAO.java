package dao;

import bean.Book;

import java.sql.*;
import java.util.ArrayList;

public class bookDAO {
    public bookDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection()throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/webbigexp?characterEncoding=UTF-8","root","123456");
    }
    public void add(Book book){
        String sql="insert into book values(?,?,?,?)";
        try(Connection c=getConnection(); PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,book.id);
            ps.setString(2,book.name);
            ps.setString(3,book.kind);
            ps.setString(4,book.time);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void update(Book book){
        String sql="update book set name=?,kind=?,time=? where id=?";
        try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1,book.name);
            ps.setString(2,book.kind);
            ps.setString(3,book.time);
            ps.setInt(4,book.id);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try(Connection c=getConnection(); Statement s=c.createStatement()){
            String sql="delete from book where id="+id;
            s.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Book get(int id){
        Book book=new Book();
        try (Connection c=getConnection();Statement s=c.createStatement()){
            String sql="select * from book where id="+id;
            ResultSet rs=s.executeQuery(sql);
            if(rs.next()){
                String name=rs.getString(2);
                String kind=rs.getString(3);
                String time=rs.getString(4);
                book.id=id;
                book.name=name;
                book.kind=kind;
                book.time=time;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return book;
    }
    public ArrayList<Book> list(){
        return list(0,Short.MAX_VALUE);
    }
    public ArrayList<Book> list(int start,int count){
        ArrayList<Book> books=new ArrayList<Book>();
        String sql="select * from book order by id asc limit ?,?";
        try (Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Book book=new Book();
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String kind=rs.getString(3);
                String time=rs.getString(4);
                book.id=id;
                book.name=name;
                book.kind=kind;
                book.time=time;
                books.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }
    public int getTotal(){
        int ans=0;
        try(Connection c=getConnection();Statement s=c.createStatement()){
            String sql="select * from book";
            ResultSet rs=s.executeQuery(sql);
            while(rs.next()){
                ans++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ans;
    }
    public ArrayList<Book> selectById(int id){
        Book book=get(id);
        ArrayList<Book> ans=new ArrayList<Book>();
        ans.add(book);
        return ans;
    }
    public ArrayList<Book> selectByName(String name){
        Book book=new Book();
        ArrayList<Book> ans=new ArrayList<Book>();
        String sql="select * from book where name=?";
        try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int id=rs.getInt(1);
                String kind=rs.getString(3);
                String time=rs.getString(4);
                book.id=id;
                book.name=name;
                book.kind=kind;
                book.time=time;
            }
            ans.add(book);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ans;
    }
    public ArrayList<Book> selectByKind(String kind){
        ArrayList<Book> ans=new ArrayList<>();
        String sql="select * from book where kind=?";
        try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1,kind);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Book book=new Book();
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String time=rs.getString(4);
                book.id=id;
                book.name=name;
                book.kind=kind;
                book.time=time;
                ans.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ans;
    }
    public ArrayList<Book> selectByTime(String time){
        ArrayList<Book> ans=new ArrayList<>();
        String sql="select * from book where time=?";
        try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1,time);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Book book=new Book();
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String kind=rs.getString(3);
                book.id=id;
                book.name=name;
                book.kind=kind;
                book.time=time;
                ans.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ans;
    }


}
