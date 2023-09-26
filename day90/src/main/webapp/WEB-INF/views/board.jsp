<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title>능단평 - 게시판</title>
   </head>
   <body>
   		<h3>게시글</h3>
   		<c:if test="${ sessionMid eq bData.mid }">
			<form name="form" method="POST">
				<input type="hidden" name="bid" value="${ bData.bid }">
				ID <input type="text" name="mid" value="${ sessionMid }" readonly> <br>
				CONTENT <input type="text" name="content" value="${ bData.content }" required> <br>
				<input type="submit" value="게시글 수정" onclick="javascript: form.action='/updateBoard';">
				<input type="submit" value="게시글 삭제" onclick="javascript: form.action='/deleteBoard';">
			</form>
   		</c:if>
   		<c:if test="${ sessionMid ne bData.mid }">
   			<form action="#" method="POST">
				ID <input type="text" name="mid" value="${ bData.mid }" readonly> <br>
				CONTENT <input type="text" name="content" value="${ bData.content }" readonly> <br>
			</form>
   		</c:if>
   		<hr>
   		<a href="main">메인 페이지</a>
   </body>
</html>