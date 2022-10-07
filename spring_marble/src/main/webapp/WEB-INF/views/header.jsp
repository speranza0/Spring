<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Insert title here</title>
</head>
<body>
	
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="main">Marble 홈</a>
		</div>
		<c:if test="${not empty user}">
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main">Marble 메인</a></li>
				<li><a href="marble">Marble 게임</a></li>
				<li><a href="list">랭킹</a></li>
				<li><a href="#">${user.id}님 환영합니다.</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logout">로그아웃</a></li>
					</ul>
				</li>
			</ul>
		</div>
		</c:if>
		<c:if test="${empty user}">
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main">Marble 메인</a></li>
				<li><a href="list">랭킹</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
					접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="loginView">로그인</a></li>
						<li><a href="joinView">회원가입</a></li>
					</ul>
				</li>
			</ul>
		</div>
		</c:if>
	</nav>
</body>
</html>