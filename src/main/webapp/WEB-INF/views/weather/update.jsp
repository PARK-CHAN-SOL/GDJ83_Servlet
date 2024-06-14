<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./update" method="post">
		<div>
			<input type="hidden" name="num" value="${requestScope.wDTO.num}">
			<div>
				<label for="city">City</label>
				<input type="text" name="city" readonly value="${requestScope.wDTO.city}">
			</div>
			
			<div>
				<label for="gion">Temperature</label>
				<input type="text" name="gion" value="${requestScope.wDTO.gion}">
			</div>
			
			<div>
				<label for="status">Status</label>
				<input type="text" name="status" value="${requestScope.wDTO.status}">		
			</div>
			
			<div>
				<label for="humidity">Humidity</label>
				<input type="text" name="humidity" value="${requestScope.wDTO.humidity}">
			</div>
		</div>
		<input type="submit" value="UPDATE">
		<button type="submit">UPDATE</button>	
	</form>

</body>
</html>