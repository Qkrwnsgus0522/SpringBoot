<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
   <head>
      <meta charset = "UTF-8">
      <title>유효성 검사 예제</title>
   </head>
   <body>
		<form action="test2" method="POST">
			ID <input type="text" name="id" value="${ apple }"> <br>
			PW <input type="password" name="password"> <br>
			<input type="submit">
		</form>
   </body>
</html>