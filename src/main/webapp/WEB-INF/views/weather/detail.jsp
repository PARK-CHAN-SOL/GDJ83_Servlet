<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도시하나의날씨정보출력</title>
</head>
<body>
	<h1>도시하나의날씨정보출력</h1>
	
	<h3>${requestScope.wDTO.city}</h3>
	<h3>${requestScope.wDTO.gion}</h3>
	<h3>${requestScope.wDTO.status}</h3>
	<h3>${requestScope.wDTO.humidity}</h3>
	
</body>
</html>