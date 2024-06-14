<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
	<form action="./update" method="post">
		<input type="hidden" name="num" value="${requestScope.sDTO.num}">
		<div>
			<label for="name">이름</label>
			<input type="text" name="name" value="${requestScope.sDTO.name}">
		</div>

		<div>
			<label for="kor">국어</label>
			<input type="number" name="kor" value="${requestScope.sDTO.kor}">
		</div>
		
		<div>
			<label for="eng">영어</label>
			<input type="number" name="eng" value="${requestScope.sDTO.eng}">
		</div>
		<div>
			<label for="math">수학</label>
			<input type="number" name="math" value="${requestScope.sDTO.math}">
		</div>

		<div>
			<button type="submit">UPDATE</button>
		</div>
	</form>
</body>
</html>