package com.tiletocode.bbs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DetailServlet", value = "/DetailServlet")
public class DetailServlet extends HttpServlet {
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String err = "";
        try {
            String n = request.getParameter("n");
            BoardDao bdao = new BoardDao();
            BoardInfo binfo = new BoardInfo();
            binfo = bdao.selectByN(n);
            request.setAttribute("binfo", binfo);
        } catch (IllegalStateException e) {
            err = "DB 연결 오류: <br>" + e;
        } catch (Exception e) {
            err = "알수없는 오류: <br>" + e;
        } finally {
            request.setAttribute("err", err);
            request.getRequestDispatcher("/detail.jsp").forward(request, response);
        }
    }
}
