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

@WebServlet(name = "ModifyServlet", value = "/ModifyServlet")
public class ModifyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String err = "";
        String num = request.getParameter("n");

        String sql = "delete from bbs where n = '"+num+"'";
        String driver = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://158.247.198.153:3306/TEST";
        String uid = "root";
        String pwd = "quality";

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
