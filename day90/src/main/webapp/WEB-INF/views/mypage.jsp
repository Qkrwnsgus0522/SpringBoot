<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title>능단평 - 마이 페이지</title>
   </head>
   <body>
   		<c:if test="${ empty sessionMid }">
   			<h3>회원가입</h3>
	        <form action="join" method="POST">
	            ID <input type="text" name="mid" required> <br>
	            PW <input type="password" name="mpw" required> <br>
	            <input type="submit" value="회원가입"> <br>
	        </form>
    	</c:if>
    	<c:if test="${ not empty sessionMid }">
   			<h3>마이페이지</h3>
			<form action="updateMember" method="POST">
				ID <input type="text" name="mid" value="${ sessionMid }" readonly> <br>
				PW <input type="password" name="mpw" required> <br>
				<input type="submit" value="비밀번호 변경"> <br>
			</form>
			<a href="deleteMember">회원탈퇴</a>
		</c:if>
		<hr>
		<a href="main">메인 페이지</a>
   </body>
</html>