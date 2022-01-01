package com.tiletocode.bbs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListServlet", value = "/ListServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String err = "";
        try {
            ArrayList<BoardInfo> list = new ArrayList<BoardInfo>();
            BoardDao bdao = new BoardDao();
            list = bdao.selectAll();
            request.setAttribute("list", list);
        } catch (IllegalStateException e) {
            err = "DB 연결에 오류가 발생했습니다." + e;
        } catch (Exception e) {
            err = "오류 발생: <br>" + e;
        } finally {
            request.setAttribute("err", err);
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String err = "";

        String title = request.getParameter("title");
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String content = request.getParameter("content");

        try {
            BoardDao bdao = new BoardDao();
            bdao.write(title, id, pass, content);
        } catch (IllegalStateException e) {
            err = "DB 연결에 오류가 발생했습니다." + e;
        } catch (Exception e) {
            err = "오류 발생: <br>" + e;
        } finally {
            request.setAttribute("err", err);
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
