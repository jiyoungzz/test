<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></ script>
<script>
$(function(){
	$("#btnLogin").click(function(){
	id=$("#id").val();
	pw=$("#pw").val();
	param={"id":id, "pw":pw};
	$.ajax({
		type: "post",
		url: "login_result.do",
		data: param,
		success: function(result){
			$("#result").html(result); 
			}
		});
	});
});
</script>
</head>
<body>
<%//@ include file="../include/menu.jsp"%>
<jsp:include page="../include/menu.jsp" />
id : <input id="id">
pw : <input type="password" id="pw">
<input type="button" id="btnLogin" value="로그인">
<div id="result"></div>
</body>
</html>
