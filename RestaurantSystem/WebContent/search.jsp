<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ค้นหาข้อมูลพนักงาน</title>
</head>
<body>
<h2>ค้นหาข้อมูลพนักงาน</h2>
<form action="EmployeeServlet?action=searchbyidorname" method="post">
	<label>ป้อนรหัสพนักงาน หรือชื่อพนักงาน</label>
	<input type="text" name="idname">
	<input type="submit" value="ค้นหา">
</form>


<c:if test="${employees != null  }">
	<c:if test="${fn:length(employees) > 0 }">
		<hr>
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
	</c:if>
	<c:if test="${fn:length(employees) == 0}">
		<hr>
		<label style="color:  red;">ไม่มีข้อมูลของพนักงานที่ค้นหา</label>
	</c:if>
	
</c:if>



</body>
</html>