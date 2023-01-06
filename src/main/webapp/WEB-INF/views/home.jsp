<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title></title>
  <link type="text/css" rel="stylesheet" href="<c:url value='/css/home.css'/>"/>
  <script src="/egovproject/webjars/jquery/3.6.0/jquery.min.js"></script>
  <script>
    $(document).ready(function(){

    });
  </script>
</head>
<body>

<img class="mainlogo" src="/egovproject/images/mainlogo2.png">

<div class="mainText">
공공서비스의 혁신으로  <br> 
시민 삶의 질을 향상시키겠습니다. 
</div>

<div class="linklist">
<a href="/egovproject/allboard.do">
<img class="mainlinkimg" src="/egovproject/images/boardlink.png">
</a>

<a href="/egovproject/allboard.do">
<img class="mainlinkimg" src="/egovproject/images/reservationlink.png">
</a>


</div>





</body>
</html>