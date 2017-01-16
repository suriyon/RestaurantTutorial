<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ลบข้อมูลพนักงาน</title>
</head>
<body>
<h2>ลบข้อมูลพนักงาน</h2>
<form action="EmployeeServlet?action=searchbyidfordelete" method="post">
	<label>ป้อนรหัสพนักงาน</label>
	<input type="text" name="idsearch" pattern="[S][0-9]{4}"
	title="รหัสพนักงานขึ้นต้นด้วย S และตามด้วยตัวเลขอีก 4 หลัก" required="required">
	<input type="submit" value="ค้นหา">
</form>
<c:if test="${employee != null and employee.id != null}">
	<hr>
	<form action="EmployeeServlet?action=delete" method="post">
		<table>
			<tr>
				<td>รหัสพนักงาน</td>
				<td>
					<input type="hidden" name="id" value="${employee.id }">
					<label>${employee.id }</label>
				</td>
			</tr>
			<tr>
				<td>ชื่อ-นามสกุล</td>
				<td>
					<label>${employee.name }</label>
				</td>
			</tr>
			<tr>
				<td>ตำแหน่ง</td>
				<td>
					<label>${employee.position }</label>
				</td>
			</tr>
			<tr>
				<td>เงินเดือน</td>
				<td>
					<label>${employee.salary }</label>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="ลบ">
				</td>
			</tr>
		</table>
	</form>
</c:if>
<c:if test="${not empty employee and employee.id == null}">
	<hr>
	<label style="color: red;">ไม่มีพนักงานที่ค้นหา</label>
</c:if>
</body>
</html>