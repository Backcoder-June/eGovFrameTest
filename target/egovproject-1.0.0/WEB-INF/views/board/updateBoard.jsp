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

				


<form action="/egovproject/${oneBoard.id}/updateboard.do" method="POST">
<table>
<tr>
<th>직무</th>
<td>
<input type="text" name="job" value="${oneBoard.job }">
</td>
</tr>

<tr>
<th>제목</th>
<td>
<input type="text" name="title" value="${oneBoard.title }">
</td>
</tr>

<tr>
<th>내용</th>
<td>
<input type="text" name="contents" value="${oneBoard.contents }">
</td>
</tr>

<tr>
<th>
<input type="submit" value="등록">
</th>
</tr>

</table>

</form>










</body>
</html>