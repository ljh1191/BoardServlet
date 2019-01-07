<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
function insertBtn(){
	if($("#name").val()==""){
		alert("이름을 입력하세요.");
		return;
	}
	if($("#pass").val()==""){
		alert("비밀번호를을 입력하세요.");
		return;
	}
	if($("#subject").val()==""){
		alert("제목을 입력하세요.");
		return;
	}
	if($("#file").val()==""){
		alert("파일을 첨부하세요.");
		return;
	}
	frm.submit();
}
</script>
</head>
<body>
	<h2>게시판글등록</h2>
	<form id = "frm" action = "insert" method = "post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="pass" name="pass"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" id="subject" name="subject"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="20" cols="50" name = "content"></textarea></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" id="filename" name="filename"></td>
			</tr>
			<tr align = "center">
				<td colspan = "2">
				<input type = "button" value = "등록" onclick = "insertBtn()">
				<input type = "reset" value = "다시쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>