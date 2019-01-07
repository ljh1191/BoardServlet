<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<table>
			<tr>
				<th>NO</th>
				<th>작성자</th>
				<th>글제목</th>
				<th>글내용</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${arr }" var="arr">
				<tr>
					<td>${arr.board_num }</td>
					<td><a href = "view?board_num=${arr.board_num }">${arr.board_name }</a></td>
					<td>${arr.board_subject }</td>
					<td>${arr.board_content }</td>
					<td>${arr.board_readcount }</td>
					<td>${arr.board_date }</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>