<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>NO</td>
<td><input type = "text" name = "num" id = "num" value = "${bb.board_num}"></td>
</tr>
<tr>
<td>작성자</td>
<td><input type = "text" name = "name" id = "name" value = "${bb.board_name}"></td>
</tr>
<tr>
<td>글제목</td>
<td><input type = "text" name = "subject" id = "subject" value = "${bb.board_subject}"></td>
</tr>
<tr>
<td>글내용</td>
<td><textarea rows="20" cols="50" name = "content">${bb.board_content}</textarea>"</td>
</tr>
<tr>
<td>조회수</td>
<td><input type = "text" name = "readcount" id = "readcount" value = "${bb.board_readcount}"></td>
</tr>
<tr>
<td>작성일</td>
<td><input type = "text" name = "date" id = "date" value = "${bb.board_date}"></td>
</tr>
<tr>
<td>첨부파일</td>
<td><a href = "">${bb.board_file}"</a></td>
</tr>
</table>
</body>
</html>