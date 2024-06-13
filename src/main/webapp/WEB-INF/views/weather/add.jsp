<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨정보입력</title>
</head>
<body>
	<h1>날씨정보입력</h1>
	<form action="./add" method="post">
		<div>
			<div>
				<label for="city">City</label>
				<input type="text" name="city">
			</div>
			
			<div>
				<label for="gion">Temperature</label>
				<input type="text" name="gion">
			</div>
			
			<div>
				<label for="status">Status</label>
				<input type="text" name="status">		
			</div>
			
			<div>
				<label for="humidity">Humidity</label>
				<input type="text" name="humidity">
			</div>
		</div>
		<input type="submit" value="등록">
		<button type="submit">등록</button>	
	</form>
</body>
</html>