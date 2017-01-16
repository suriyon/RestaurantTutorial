<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>หน้าหลัก</title>
</head>
<body>
<h2>หน้าหลัก</h2>
<table border="1">
	<thead>
		<tr>
			<th>รหัสพนักงาน</th>
			<th>ชื่อ-นามสกุล</th>
			<th>ตำแหน่ง</th>
			<th>เงินเดือน</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${employees }" var="employee">
			<tr>
				<td style="text-align: center;">${employee.id}</td>
				<td>${employee.name}</td>
				<td style="text-align: center;">${employee.position}</td>
				<td style="text-align: right;">${employee.salary}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>