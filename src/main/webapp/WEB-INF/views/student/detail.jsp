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
	<form action="./delete" method="post" id="frm">
		<input type="hidden" value="${requestScope.sDTO.num}" name="num">
	</form>
	<button id="del">DELETE</button>
	<button id="up">UPDATE</button>
	<script type="text/javascript">
		const del = document.getElementById("del");
		const frm = document.getElementById("frm");
		const up = document.getElementById("up");
		del.addEventListener("click", function() {
			frm.submit();
		});
		up.addEventListener("click", function() {
			frm.action = "./update";
			frm.method = "get";
			frm.submit();
		});
	</script>
</body>
</html>