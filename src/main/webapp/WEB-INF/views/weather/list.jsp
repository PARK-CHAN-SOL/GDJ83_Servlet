<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨정보전체출력</title>
<link href="/resources/css/tables.css" rel="stylesheet">
</head>
<body>
	<h1>날씨정보전체출력</h1>
	<table class="tbl">
		<thead>
			<tr>
				<th>Num</th>
				<th>City</th>
				<th>Temperature</th>
				<th>Status</th>
				<th>Humidity</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${requestScope.list}" var="wDTO">
				<tr>
					<td>${pageScope.wDTO.num}</td>
					<!-- 실제 경로가 아니라 주소창에 있는 경로를 참조 -->
					<td><a href="./detail?num=${pageScope.wDTO.num}">${pageScope.wDTO.city}</a></td>
					<td>${pageScope.wDTO.gion}</td>
					<td>${pageScope.wDTO.status}</td>
					<td>${pageScope.wDTO.humidity}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>