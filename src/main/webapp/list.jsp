<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tiletocode.bbs.BoardInfo" %>


<%
    ArrayList<BoardInfo> list =(ArrayList<BoardInfo>)request.getAttribute("list");
    String err = (String) request.getAttribute("err");
%>

<html>

<head>
    <title>게시판 prototype v1</title>
    <meta charset="UTF-8" name="viewport" content="width=device-width">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <style>
        a {
            text-decoration-line: none;
        }
    </style>
</head>

<body>
<main class="main">
    <div class="notice margin-top">
        <h1 class="hidden">목록</h1>
        <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
            <thead>
            <tr>
                <th style="background-color: #6667AB; width: 50px">번호</th>
                <th style="background-color: #6667AB; width: 300px">제목</th>
                <th style="background-color: #6667AB; width: 150px">작성자</th>
                <th style="background-color: #6667AB; width: 200px">작성일</th>
            </tr>
            </thead>
            <tbody>

            <%  if(list != null) {
                    for(int i=0; i<list.size(); i++) {
            %>

            <tr>
                <td><%=list.get(i).getN()%></td>
                <td class="title indent text-align-left"><a href="DetailServlet?n=<%=list.get(i).getN()%>"><%=list.get(i).getTitle()%></a></td>
                <td><%=list.get(i).getId()%></td>
                <td><%=list.get(i).getTime()%></td>
            </tr>

            <%
                    }
                }
            %>

            </tbody>
        </table>
        <a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
    </div>
</main>
</body>
</html>
