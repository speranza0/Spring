<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>login.jsp</h1>

<%-- <c:if test="${not empty pageContext.request.userPrincipal}">
<p> is Log-In </p>
</c:if>

<c:if test="${empty pageContext.request.userPrincipal}">
<p> is Log-Out </p>
</c:if>
--%>

<s:authorize ifAnyGranted="ROLE_USER">
<p> is Log-In </p>
</s:authorize>

<s:authorize ifNotGranted="ROLE_USER">
<p> is Log-Out </p>
</s:authorize>

<%-- USER ID : ${pageContext.request.userPrincipal.name}<br /> --%>
USER ID : <s:authentication property="name" /><br />
<a href="${pageContext.request.contextPath}/j_spring_security_logout">Log Out</a><br />
</body>
</html>