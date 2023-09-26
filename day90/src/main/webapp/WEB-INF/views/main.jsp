<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>능단평 - 메인 페이지</title>
</head>
<body>
    <c:if test="${ sessionMid eq null }">
    	<h3>로그인</h3>
        <form action="login" method="POST">
            ID <input type="text" name="mid" required> <br>
            PW <input type="password" name="mpw" required>
            <input type="submit" value="로그인"> 
            <hr>
            <a href="join">회원가입</a>
        </form>
    </c:if>

    <c:if test="${ sessionMid ne null }">
    	<h3>내정보</h3>
        <form action="insertBoard" method="POST">
            <a href="logout">로그아웃</a> <br>
            <a href="mypage">마이페이지</a> <br>
            <hr>
            <h3>게시글 작성</h3>
            <input type="hidden" name="mid" value="${ sessionMid }">
            <input type="text" name="content" placeholder="내용을 입력해주세요" required>
            <input type="submit" value="글작성">
        </form>
    </c:if>

    <hr>
	<h3>게시판</h3>
    <c:if test="${fn:length(bDatas) <= 0}">
        <h1>출력할 글이 없습니다.</h1>
    </c:if>
    <c:if test="${fn:length(bDatas) > 0}">
    <table border="1">
	    <tr>
	        <th>글 번호</th>
	        <th>작성자</th>
	        <th>글 내용</th>
	    </tr>
        <c:forEach var="bData" items="${ bDatas }">
      	<tr>
            <td><a href="board?bid=${ bData.bid }">${ bData.bid }</a></td>
            <td><c:if test="${ bData.mid eq null }">탈퇴회원</c:if><c:if test="${ bData.mid ne null }">${ bData.mid }</c:if></td>
            <td>${ bData.content }</td>
        </tr>
        </c:forEach>
    </c:if>
    </table>
</body>
</html>