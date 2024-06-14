<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보입력</title>
</head>
<body>
	<h1>학생정보입력 페이지</h1>
	
	<!-- 개발자에게 가장 중요한 태그임 -->
	<!-- 파라미터의 key값으로는 name속성에 기입한 값이 들어감 -->
	<!-- name속성이 매우매우 중요함 -->
	<!-- 파라미터의 이름은 setter의 이름과 동일하게 맞춰주세요 -->
	<form action="/student/add" method="post">
		<div>
			<label for="name">이름</label>
			<input type="text" name="name" id="name">
		</div>

		<div>
			<label for="kor">국어</label>
			<input type="number" name="kor" id="kor">
		</div>
		
		<div>
			<label for="eng">영어</label>
			<input type="number" name="eng" id="eng">
		</div>
		<div>
			<label for="math">수학</label>
			<input type="number" name="math" id="math">
		</div>

		<div>
			<input type="submit" value="등록">
			<button type="submit">작성</button>
		</div>
	</form>
	
</body>
</html>