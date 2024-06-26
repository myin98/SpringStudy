<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<!-- 변수 선언 및 할당 -->
<c:set scope="request" var="a" value="나" />
<p>${a}</p>

<hr>
<!-- 조건문 1 -->
<c:if test="${a == '가'}">
<p>== 비교자로 화면에 출력</p>
</c:if>

<c:if test="${a eq '가'}">
<p>eq 비교자로 화면에 출력</p>
</c:if>


<!-- 조건문 2 -->
<c:choose> 
	<c:when test="${a == '나'}">a 값이 '나'이면 실행</c:when> 
	<c:when test="${a eq '다'}">a 값이 '다'이면 실행</c:when>
	<c:otherwise>a 값이 '나', '다' 값이 아닐 경우 실행</c:otherwise> 
</c:choose>


<hr>
<!-- 반복문 -->
<ul>
<c:forEach var="row" begin="0" end="10" step="1" varStatus="s">
	<li>${s.index} <span style="color: blue;">${s.count}</span> ${row}</li>
</c:forEach>
</ul>

</body>
</html>