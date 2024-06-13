<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생한명정보</title>
</head>
<body>
	<h1>학생한명정보출력</h1>

	<!-- EL (Expression Language -->
	<%-- ${스코프영역명.속성명} --%>
	<!-- getter의 이름: get을 빼고 첫글자를 소문자로 바꾼것 -->
	<!-- setter의 이름: set을 빼고 첫글자를 소문자로 바꾼것 -->
	<h3>${requestScope.sDTO.num}</h3>
	<h3>${requestScope.sDTO.name}</h3>
	<h3>${requestScope.sDTO.kor}</h3>
	<h3>${requestScope.sDTO.eng}</h3>
	<h3>${requestScope.sDTO.math}</h3>
	<h3>${requestScope.sDTO.total}</h3>
	<h3>${requestScope.sDTO.avg}</h3>
</body>
</html>