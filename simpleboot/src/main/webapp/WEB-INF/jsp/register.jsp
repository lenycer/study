<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ������</title>
</head>
<body>
<c:url value="/register/user" var="registerUrl"/>
<form action="${registerUrl}" method="post">       
	���̵� : <input type="text" name="username"/><br/>
	��й�ȣ : <input type="password" name="password"/><br/>
	���� : <input type="text" name="nick"/><br/>
	���� : <input type="text" name="authority" value="ROLE_USER"/><br/>
	
	<input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
	<button type="submit" class="btn">Ȯ��</button>
</form>
</body>
</html>