<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Day03 Visit2 화면 구현</h3>
	<div>
		<h4>방문록 작성</h4>
		내용 : <input id = "contentInput" type = "text" /> <br/>
		나이 : <input id = "ageInput" type = "text" /> <br/><br/>
		<button type = "button" onclick = "_write()">등록</button>
	</div>
	<br/><br/><br/>
	<div>
		<div>방문자 목록</div>
		<table border = "1">
			<thead>
				<tr>
					<th>num</th> <th>content</th> <th>age</th> <th>etc</th>
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>

	<script src = "task1.js"></script>
</body>
</html>