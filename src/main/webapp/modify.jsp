<%@ page import="com.tiletocode.bbs.BoardInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  BoardInfo binfo = (BoardInfo) request.getAttribute("binfo"); %>
<html>
<head>
    <title>글 수정하기</title>
    <meta charset="UTF-8" name="viewport" content="width=device-width">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
</head>
<body>
<form action="ModifyServlet">
    <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
        <thead>
        <tr>
            <th colspan="2" style="background-color: #eeeeee; text-align: center;">글 수정하기</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="100" value="<%=binfo.getTitle()%>"></td>
        </tr>
        <tr>
            <td><input type="text" class="form-control" placeholder="작성자" name="id" maxlength="20" value="<%=binfo.getId()%>"></td>
        </tr>
        <tr>
            <td><input type="password" class="form-control" placeholder="비밀번호(숫자)" name="pass"></td>
        </tr>
        <tr>
            <td><textarea class="form-control" placeholder="글 내용" name="content" maxlength="1000" style="height: 350px"></textarea></td>
        </tr>
        </tbody>

    </table>
    <input type="submit" class="btn btn-primary pull-right" value="수정완료">
</form>

</body>
</html>
