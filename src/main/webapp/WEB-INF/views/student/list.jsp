<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<h1>학생정보리스트</h1>

	<div>
		<img alt="" src="/resources/images/anim5.png">
	</div>
	<!-- JSTL -->

	<!-- for(데이터타입 변수명:배열명) -->
	<table class="tbl">
		<thead>
			<tr>
				<th>번호</th>
				<th class="tname">이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${requestScope.list}" var="sDTO">
				<tr>
					<td>${pageScope.sDTO.num}</td>
					<td class="tname"><a href="./detail?num=${pageScope.sDTO.num}">${pageScope.sDTO.name}</a></td>
					<td>${pageScope.sDTO.kor}</td>
					<td>${pageScope.sDTO.eng}</td>
					<td>${pageScope.sDTO.math}</td>
				</tr>
				<!-- <hr> -->
				<!-- 수평선 하나 긋기 -->
			</c:forEach>
		</tbody>
	</table>
	<a href="/student/add">학생정보추가</a>
	<div>
		
	</div>
</body>
</html>