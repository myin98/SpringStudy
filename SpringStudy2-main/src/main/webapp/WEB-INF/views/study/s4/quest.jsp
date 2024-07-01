<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QUEST</title>
</head>
<body>
${map}
<%-- <h1>${map.getClass().getName()}</h1>
<h1>${map.getClass().getName()}</h1> --%>
<h1>전달 받은 Map 객체 받아오기</h1>
<h1>Name: ${linkedHashMap.name}</h1>
<h1>Age: ${linkedHashMap.age}</h1>


</body>
</html>