package com.tiletocode.bbs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "WriteServlet", value = "/WriteServlet")
public class WriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String err = "";
        String title = request.getParameter("title");
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String content = request.getParameter("content");

        String sql = "insert into bbs(title,id,pass,content) values('"+title+"', '"+id+"', '"+pass+"', '"+content+"')";
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://ledx-1.c0puka4oucjv.ap-northeast-2.rds.amazonaws.com:3306/TEST";
        String uid = "fiercegear";
        String pwd = "ipaq2210";

        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, uid, pwd);
            stmt = con.createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("SQLException : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException : " + e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        response.getWriter().append("<script> location.replace('./ListServlet'); </script>");
    }
}
