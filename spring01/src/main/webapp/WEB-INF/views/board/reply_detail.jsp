<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script>
$(document).ready(function(){
	$("#btnReplyDelete").click(function(){
		$.ajax({
			type: "delete",
			url:"${path}/reply/delete/${dto.rno}",
			success: function(result){
				if(result=="success"){
					alert("삭제되었습니다.");
					$("#modifyReply").css("visibility","hidden");
					listReply2("1");
				}
			}
		});
	});
	$("#btnReplyUpdate").click(function(){
		var replytext=$("#detail_replytext").val();
		$.ajax({
			type:"put",
			url: "${path}/reply/update/${dto.rno}",
			headers: {"Content-Type":"application/json"},
			data: JSON.stringify({
				replytext:replytext
			}),
			dataType:"text",
			seccess: function(result){
				if(result == "success"){
					$("#modifyReply").css("visibillity","hidden");
					listReply2("1");
				}
			}
		});
	});
	$("#btnReplyClose").click(function(){
		$("#modifyReply").css("visivility","hidden");
	});
});
</script>
</head>
<body>
${dto.rno}<br>
<textarea id="detail_replytext" rows="3" cols="40">${dto.replytext}</textarea>
<div style="text-align: center;">
<c:if test="${sessionScope.userid == dto.replyer }">
	<button id="btnReplyUpdate" type="button">수정</button>
	<button id="btnReplyDelete" type="button">삭제</button>
	</c:if>
	<button id="btnReplyClose" type="button">닫기</button>
	</div>
</body>
</html>