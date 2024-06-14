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
	<form action="./delete" method="post" id="frm">
		<input type="hidden" name="num" value="${requestScope.wDTO.num}">
	</form>
	<!-- <form action="./update" method="post" id="frm2" style="display:none;"></form> -->
	<button id="del">DELETE</button>
	<button id="up">UPDATE</button>
	<script type="text/javascript">
		const del = document.getElementById("del");
		const frm = document.getElementById("frm");
		const up = document.getElementById("up");

		del.addEventListener("click", function() {
			frm.submit();
		})
			
		up.addEventListener("click", function() {
			frm.setAttribute("action", "./update");
			frm.setAttribute("method", "get");
			frm.submit();
		})
	</script>
</body>
</html>