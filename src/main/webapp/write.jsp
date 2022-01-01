<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글쓰기</title>
    <meta charset="UTF-8" name="viewport" content="width=device-width">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
</head>
<body>
<form action="WriteServlet">
    <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
        <thead>
        <tr>
            <th colspan="2" style="background-color: #eeeeee; text-align: center;">글쓰기</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="100"></td>
        </tr>
        <tr>
            <td><input type="text" class="form-control" placeholder="작성자" name="id" maxlength="20"></td>
        </tr>
        <tr>
            <td><input type="password" class="form-control" placeholder="비밀번호(숫자)" name="pass"></td>
        </tr>
        <tr>
            <td><textarea class="form-control" placeholder="글 내용" name="content" maxlength="1000" style="height: 350px"></textarea></td>
        </tr>
        </tbody>

    </table>
    <input type="submit" class="btn btn-primary pull-right" value="작성완료">
</form>

</body>
</html>
