<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/menu.jsp"%>
	<form name="form1" method="post">
		우편번호 :
		<input name="zipcode" id="post_code" readonly size="10">
		<input type="button" onclick="showPostcode()" value=" 우편번호 찾기">
		<br>
		주소 : <input name="address1" id="address1" size="60">
		<br>
		상세주소 : <input name="address2" id="address2">
	</form>
</body>
</html>