<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.tiletocode.bbs.BoardInfo" %>

<%
            BoardInfo binfo = (BoardInfo) request.getAttribute("binfo");
    String err = (String) request.getAttribute("err");
%>
<html>
<head>
    <title><%=binfo.getN()%>번글</title>
    <meta charset="UTF-8" name="viewport" content="width=device-width">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
</head>
<body>
<form action="DeleteServlet">
<div>
    <h3>작성글 내용</h3>
    <table class="table">
        <tbody>
        <tr>
            <th style="background-color: #6667AB;">제목</th>
            <td colspan="3"><%=binfo.getTitle()%></td>
        </tr>
        <tr>
            <th style="background-color: #6667AB;">작성일</th>
            <td style="background-color: #dddddd;" colspan="3"><%=binfo.getTime()%></td>
        </tr>
        <tr>
            <th style="background-color: #6667AB;">작성자</th>
            <td><%=binfo.getId()%></td>
            <th style="background-color: #6667AB;">글번호</th>
            <td><%=binfo.getN()%></td>
        </tr>
        <tr class="content">
            <td style="background-color: #dddddd;" colspan="4"><%=binfo.getContent()%></td>
        </tr>
        </tbody>
    </table>
    <input type="hidden" class="form-control" name="n" value="<%=binfo.getN()%>">
    <%
        request.setAttribute("n", binfo.getN());
    %>
    <a href="ListServlet" class="btn btn-primary pull-right">전체글</a>
    <a href="modify.jsp" class="btn btn-primary pull-right">수정하기</a>
    <input type="submit" class="btn btn-primary pull-right" value="삭제하기">
</div>
</form>
</body>
</html>
