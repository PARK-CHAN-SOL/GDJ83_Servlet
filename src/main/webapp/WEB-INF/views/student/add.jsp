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
			<label for="num">번호</label>
			<input type="number" name="num" id="num">
		</div>

		<div>
			<label for="name">이름</label>
			<input type="text" name="name" id="name">
		</div>

		<div>
			<label for="avg">평균</label>
			<input type="number" name="avg" id="avg">
		</div>
		
		<div>
			<label></label>
			<input type="radio" name="ch" value="여성">
			<input type="radio" name="ch" value="남성">
		</div>
		
		<div>
			<select name="mobile">
				<option>KT</option>
				<option>SKT</option>
				<option>LG</option>
			</select>
		</div>
		
		<div>
			<input type="checkbox" name="ch2" value="1st chkbox">
			<input type="checkbox" name="ch2" value="2nd chkbox">
			<input type="checkbox" name="ch2" value="3rd chkbox">
		</div>
		
		<div>
			<textarea rows="" cols="" name="textArea"></textarea>
		</div>
		
		<div>
			<input type="submit" value="등록">
			<button type="submit">작성</button>
		</div>
	</form>
	
</body>
</html>