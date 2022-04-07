<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>작성 페이지</h1>

<form action="insertBoard.do" method="post">
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" value="${member.name}" readonly></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="글 작성"></td>
		</tr>
	</table>
</form>

<a href="main.do ">메인페이지</a>

</body>
</html>