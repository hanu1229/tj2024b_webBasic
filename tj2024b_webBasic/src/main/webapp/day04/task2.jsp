<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h2>대기명단 등록</h2>
		<table>
			<tr>
				<td>전화번호 : </td>
				<td><input id = "phoneInput"/></td>
			</tr>
			<tr>
				<td>인원수 &nbsp;&nbsp;&nbsp;: </td>
				<td><input id = "peopleInput"/></td>
			</tr>
		</table>
		<br/>
		<button style = "margin-left : 215px;" onclick = "_write()">등록</button>
	</div>
	<div>
		<h2>대기명단 출력</h2>
		<table border = "1">
			<thead>
				<tr>
					<th>대기번호</th>
					<th>등록번호</th>
					<th>전화번호</th>
					<th>인원수</th>
					<th>수정/삭제</th>
				</tr>
			</thead>
			<tbody id = "printTbody">
				
			</tbody>
		</table>
	</div>
	<script src = "task2.js"></script>
</body>
</html>