<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title></title>
  <script src="/egovproject/webjars/jquery/3.6.0/jquery.min.js"></script>
  <script>
    $(document).ready(function(){

    });
  </script>
</head>
<body>
상세페이지 입니다. 

직업 : ${oneBoard.job } <br>
제목 : ${oneBoard.title } <br>
내용 : ${oneBoard.contents } <br>

<br> 

<form action="/egovproject/${oneBoard.id }/updateboard.do" method="GET">
<input type="submit" value="수정">
</form>
<form action="/egovproject/${oneBoard.id }/deleteboard.do" method="POST">
<input type="submit" value="삭제">
</form>

</body>
</html>