<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>구구단</title>
  <link rel="icon" href="<%=request.getContextPath()%>/resources/images/logo.png" type="image/x-icon">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
  	body {background-color: #2d2521;}
  	hr {color: white; border-top: 10px solid #036dff;}
  </style>
<script>
const DATA = () => {
	var html = '<option value="A">전체</option>';
	for(var i = 1; i < 10; i++) {
		html += '<option value="' + i + '">' + i +'단</option>';
	}
	document.getElementById("dan").innerHTML = html;
};
</script>
</head>
<body onload="DATA()">

	<div class="container mt-3">
	  <h1 class="text-white text-center">구구단</h1>
		<form action="" method="get">
			<div class="input-group mb-3">
	       <select class="form-select" name="dan" id="dan"></select>
				<button class="btn btn-success" type="submit">
	         <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-view-list" viewBox="0 0 16 16">
	           <path d="M3 4.5h10a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2m0 1a1 1 0 0 0-1 1v3a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1v-3a1 1 0 0 0-1-1zM1 2a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 0 1h-13A.5.5 0 0 1 1 2m0 12a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 0 1h-13A.5.5 0 0 1 1 14"/>
	         </svg>
				</button>
			</div>
	  </form>
	</div>
  
<!-- 반복 시작 -->
	<!-- List로 받았을때 반복문 처리 -->
	<c:forEach var="i" items="${list1}" varStatus="status">
		<div class="container mt-3">
	  		<h2 class="text-white text-center">${status.count}단</h2>
	  		<div class="row text-center mt-3 fs-3">
	
			<c:forEach var="j" items="${i}">    
		    	<div class="col-sm-4">
	      			<p class="text-bg-light">${j}</p>
	    		</div>
		  	</c:forEach>
		  	  
	  		</div>
		</div>
	</c:forEach>

<hr>

	<!-- 데이터베이스로 받았을때 반복문 처리 -->
	<c:forEach var="i" items="${list2}" varStatus="status" step="9">
		<div class="container mt-3">
	  		<h2 class="text-white text-center">${status.count}단</h2>
	  		<div class="row text-center mt-3 fs-3">
	
			<c:forEach var="j" begin="0" end="8">
		    	<div class="col-sm-4">
	      			<p class="text-bg-light">${list2[status.index + j].dan} * ${list2[status.index + j].su} = ${list2[status.index + j].dan * list2[status.index + j].su}</p>
	    		</div>
		  	</c:forEach>
		  	
	  		</div>
		</div>
	</c:forEach>
<!-- 반복 끝 -->

</body>
</html>