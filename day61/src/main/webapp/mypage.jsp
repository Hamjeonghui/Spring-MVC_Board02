<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateMember.do" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"
					value="${member.id}" readonly /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"
					value="${member.password}" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${member.name}</td>
			</tr>
			<tr>
				<td>회원등급</td>
				<td>${member.role}</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="비밀번호변경"></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="main.do">메인페이지</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="deleteMember.do?id=${member.id}">회원탈퇴</a>

</body>
</html>