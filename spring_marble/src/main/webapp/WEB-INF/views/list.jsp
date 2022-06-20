<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>Marble 랭킹</title>
</head>
<body>
	<%@ include file="header.jsp" %>
		<div class="container">
			<div class="row">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th style="background-color: #eeeeee; text-align: center;">순위</th>
							<th style="background-color: #eeeeee; text-align: center;">아이디</th>
							<th style="background-color: #eeeeee; text-align: center;">주사위 합계</th>
							<th style="background-color: #eeeeee; text-align: center;">주사위 횟수</th>
							<th style="background-color: #eeeeee; text-align: center;">바퀴 수</th>
							<th style="background-color: #eeeeee; text-align: center;">주사위 평균</th>
						</tr>
						</thead>
					<tbody>
					<c:forEach items="${list}" var="rank">
					<c:set var ="i" value="${i+1}" />
						<tr>
							<td>${i}</td>
							<td>${fn:substring(rank.id, 0, 3)}</td>
							<td>${rank.dicesum}</td>
							<td>${rank.dicecount}</td>
							<td>${rank.roundnum}</td>
							<td><fmt:formatNumber value="${rank.dicesum / rank.dicecount}" pattern=".00" /></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>