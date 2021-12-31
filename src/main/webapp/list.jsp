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
    <meta charset="UTF-8">
    <link href="style.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<main class="main">
    <div class="notice margin-top">
        <h1 class="hidden">목록</h1>
        <table class="table">
            <thead>
            <tr>
                <th class="w60">번호</th>
                <th class="expand">제목</th>
                <th class="w100">작성자</th>
                <th class="w100">작성일</th>
            </tr>
            </thead>
            <tbody>

            <%  if(list != null) {
                    for(int i=0; i<list.size(); i++) {
            %>

            <tr>
                <td><%=list.get(i).getNumber()%></td>
                <td class="title indent text-align-left"><a href="ListServlet?id=<%=list.get(i).getTitle()%>"><%=list.get(i).getTitle()%></a></td>
                <td><%=list.get(i).getId()%></td>
                <td><%=list.get(i).getTime()%></td>
            </tr>

            <%
                    }
                }
            %>

            </tbody>
        </table>
    </div>
</main>
</body>
</html>