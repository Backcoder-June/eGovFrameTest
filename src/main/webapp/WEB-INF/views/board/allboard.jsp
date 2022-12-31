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

<c:forEach items="${allBoard }" var="eachboard">
<hr>
${eachboard.job } <br> 
<a href ="/egovproject/${eachboard.title }/oneboard.do"> ${eachboard.title } </a><br> 
${eachboard.contents } <br> 
<hr>
</c:forEach>






</body>
</html>