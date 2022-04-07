<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>상세 페이지</h1>

<form action="updateBoard.do" method="post">
	<input type="hidden" name="bid" value="${data.bid}">
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${data.title}"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${data.writer}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content" value="${data.content}"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="글 변경"></td>
		</tr>
	</table>
</form>

<a href="main.do">메인페이지</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="deleteBoard.do?bid=${data.bid}">글 삭제</a>

</body>
</html>