<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function join() {
		location.href = "/www/join.do"
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<form name="form" method="post" action="login_check.do">
	<body>
		<table>
			<tr height="40px">
				<td>ID</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr height="40px">
				<td>패스워드</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick="join()">

	</body>
</form>
</html>