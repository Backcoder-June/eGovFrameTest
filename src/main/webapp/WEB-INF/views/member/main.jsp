<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>현재시간 ${serverTime}</p>

	<!-- 로그인중이 아닐 때에만 Login 버튼이 보임  -> taglib ( security/tags ) 때문에 가능 -->
	<sec:authorize access="isAnonymous()">
 		<a href='${pageContext.request.contextPath}/loginPage.do'>Login</a>
	</sec:authorize>

	<!-- 로그인 중일 경우에만 Logout 버튼이보임 -->
	<sec:authorize access="isAuthenticated()">
		<form action="${pageContext.request.contextPath}/logout" method="POST">
			<input id="logoutBtn" type="submit" value="Logout" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
	</sec:authorize>
	<form action="${pageContext.request.contextPath}/userPage/userTest.do" method="POST">

		<input id="logoutBtn" type="submit" value="userPage" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
</body>
</html>