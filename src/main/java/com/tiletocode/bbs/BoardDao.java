package com.tiletocode.bbs;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {
    private static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://ledx-1.c0puka4oucjv.ap-northeast-2.rds.amazonaws.com:3306/TEST";
    private static String USER = "fiercegear";
    private static String PASS = "ipaq2210";

    public static Connection getConnection() {
        try {
            Class.forName(RDB_DRIVE);
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        } catch(Exception e) {
            throw new IllegalStateException(e);
        }
    }
    public ArrayList<BoardInfo> selectAll() {
        Connection con = null;
        Statement smt = null;
        ArrayList<BoardInfo> list = new ArrayList<BoardInfo>();
        String sql = "SELECT * FROM bbs";
        try {
            con = getConnection();
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                BoardInfo bi = new BoardInfo();
                bi.setNumber(rs.getInt("number"));
                bi.setTitle(rs.getString("title"));
                bi.setId(rs.getString("id"));
                bi.setTime(rs.getTimestamp("time"));
                bi.setPass(rs.getInt("pass"));
                list.add(bi);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            if(smt != null) {
                try {
                    smt.close();
                } catch (SQLException ignore){}
            }
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ignore){}
            }
        }
        return list;
    }
}
