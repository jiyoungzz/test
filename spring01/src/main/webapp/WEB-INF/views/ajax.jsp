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
	$.ajax({
		type: "post",
		url: "background.do",
		success: function(result){
		console.log("test:"+result);
		$("#result").html("상품명:"+result.name+",가격:"+result.price);
		}
	});
});
</script>
</head>
<body>
<%//@include file="../include/menu.jsp"%>
<jsp:include page="../include/menu.jsp" />
<div id="result"></div>
</body>
</html>
