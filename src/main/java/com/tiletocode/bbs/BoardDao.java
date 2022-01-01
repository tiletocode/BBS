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
        String sql = "SELECT * FROM bbs order by n desc";
        try {
            con = getConnection();
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()) {
                BoardInfo bi = new BoardInfo();
                bi.setN(rs.getInt("n"));
                bi.setTitle(rs.getString("title"));
                bi.setId(rs.getString("id"));
                bi.setTime(rs.getTimestamp("time"));
                bi.setPass(rs.getString("pass"));
                bi.setContent(rs.getString("content"));
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
    public BoardInfo selectByN(String n) {
        Connection con = null;
        Statement smt = null;

        BoardInfo binfo = new BoardInfo();

        String sql = "SELECT * FROM bbs WHERE n = '"+n+"'";
        try {
            con = getConnection();
            smt = con.createStatement();

            ResultSet rs = smt.executeQuery(sql);

            while (rs.next()) {
                binfo.setN(rs.getInt("n"));
                binfo.setTitle(rs.getString("title"));
                binfo.setId(rs.getString("id"));
                binfo.setTime(rs.getTimestamp("time"));
                binfo.setPass(rs.getString("pass"));
                binfo.setContent(rs.getString("content"));
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
        return binfo;
    }

    public int write(String title, String id, String pass, String content) {
        String sql = "insert into bbs(title, id, pass, content) values(?,?,?,?)";
        Connection con = null;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, id);
            stmt.setString(3, pass);
            stmt.setString(4, content);

            return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
