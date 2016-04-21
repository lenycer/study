<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
</head>
<body>
<c:url value="/register/user" var="registerUrl"/>
<form action="${registerUrl}" method="post">       
	아이디 : <input type="text" name="username"/><br/>
	비밀번호 : <input type="password" name="password"/><br/>
	별명 : <input type="text" name="nick"/><br/>
	권한 : <input type="text" name="authority" value="ROLE_USER"/><br/>
	
	<input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
	<button type="submit" class="btn">확인</button>
</form>
</body>
</html>