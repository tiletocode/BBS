package com.tiletocode.bbs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharEncoding implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        //브라우저에게 코드를 UTF-8로 보냄
        resp.setCharacterEncoding("UTF-8");
        //브라우저에게 UTF-8로 읽을것을 명시
        resp.setContentType("text/html; charset=UTF-8");
        //브라우저가 보낸 post를 UTF-8로 읽음
        req.setCharacterEncoding("UTF-8");  //Before Filter
        chain.doFilter(req, resp);
                                            //After Filter
    }
}
