<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<script>
function passwordCheck(){
    var password = document.getElementById('password').value;	
    var passwordCheck = document.getElementById('passwordCheck').value;
    
    
    
    if(passwordCheck==""){
    	document.getElementById('passwordCheckText').value ="";
    }else if (password != passwordCheck){
    	document.getElementById('passwordCheckText').value ="비밃번호를 확인해주세요";
    }else{
    	document.getElementById('passwordCheckText').value ="ok";
    }
}
</script>
</head>	
	
<section>
	<header class="major">
		<h2>회원가입</h2>
	</header>
	<form name="joinform" action="/www/join_ok.do" method="get">
		<table>
			<thead>
				<tr>
					<td>아이디</td>
					<th><input type="text" name="id" /></th>
				</tr>
				<tr>
					<td>비밀번호</td>
					<th><input type="password" id="password" name="password" /></th>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<th><input type="password" id="passwordCheck" name="passwordCheck" onkeyup="passwordCheck()"/></th>
					<td id="passwordCheckText"></td>
				</tr>
				<tr>
					<td>성명</td>
					<th><input type="text" id="name" name="name" /></th>
				</tr>
				<tr>
					<td>휴대폰번호</td>
					<th><input type="text" id="telephone" name="telephone" /></th>
				</tr>
				<tr>
					<td>이메일</td>
					<th><input type="text" id="email" name="email" /></th>
				</tr>
			</thead>
		</table>
		<input type="submit" value="회원가입"/>
		<input type="button" value = "확인"   onclick="passwordCheck()">
		<a onclick="passwordCheck()">확인</a>
	</form>
</section>