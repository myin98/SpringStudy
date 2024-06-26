<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<style type="text/css">
.text-center {text-align: center;}
.text-start {text-align: left;}
.body {display: flex; justify-content: center;}
.in-box {width: 30vw;}
.in-box li:hover {background-color: #d3e3fd; cursor: pointer;}
a {text-decoration: none; color: #000; font-size: 1.5rem;}
</style>
</head>
<body>
<h1 class="text-center">스프링 알아보기</h1>
<div class="body">
	<ol class="in-box text-start">
		<li>
			<a href="/s1">스프링 URL</a>
		</li>
		<li>
			<a href="/s2">파라메터 전달(MODEL, REDIRECT)</a>
		</li>
		<li>
			<a href="/s3">JSTL 데이터 제어하기</a>
		</li>
		<li>
			<a href="/s4">경로 변수 이용하여 페이지 출력하기</a>
		</li>
	</ol>
</div>
</body>
</html>