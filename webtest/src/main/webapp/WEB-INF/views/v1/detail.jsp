<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://github.com/JosephBean/SpringStudy2/blob/main/src/main/webapp/resources/images/logo.png?raw=true" rel="icon" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>DETAIL</title>
</head>
<body>

    <div class="container mt-3">
        <h1 class="text-center bg-success text-dark bg-opacity-50">DETAIL</h1>
        <form action="/v1/edit" method="post">
            <input type="hidden" name="no" value="${dto.no}">
            <div class="mb-3 mt-3">
              <label for="title" class="form-label">Title:</label>
              <input type="text" class="form-control" id="title" placeholder="Enter title" name="title" required autocomplete="off" value="${dto.title}">
            </div>
            <div class="mb-3">
              <label for="content" class="form-label">Content:</label>
              <input type="text" class="form-control" id="content" placeholder="Enter content" name="content" autocomplete="off" value="${dto.content}">
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-primary me-md-2 btn-min-size" type="submit">수정</button>
                <c:if test="${dto.accept == false}">
                    <a class="btn btn-success btn-min-size" href="/v1/detail?no=${dto.no}&type=1">승인</a>
                </c:if>
                <c:if test="${dto.accept == true}">
                    <a class="btn btn-warning btn-min-size" href="/v1/detail?no=${dto.no}&type=0">미승인</a>
                </c:if>
                <a class="btn btn-secondary btn-min-size" href="/v1/list">취소</a>
            </div>
        </form>
    </div>
</body>
</html>