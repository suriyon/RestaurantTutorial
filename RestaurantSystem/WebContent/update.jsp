<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>แก้ไขข้อมูลพนักงาน</title>
</head>
<body>
<h2>แก้ไขข้อมูลพนักงาน</h2>
<form action="EmployeeServlet?action=searchbyidforupdate" method="post">
	<label>ป้อนรหัสพนักงาน</label>
	<input type="text" name="idsearch" pattern="[S][0-9]{4}"
	title="รหัสพนักงานขึ้นต้นด้วย S และตามด้วยตัวเลขอีก 4 หลัก" required="required">
	<input type="submit" value="ค้นหา">
</form>
<c:if test="${employee != null and employee.id != null}">
	<hr>
	<form action="EmployeeServlet?action=update" method="post">
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
					<input type="text" name="name" placeholder="enter employee name"
					required="required" value="${employee.name }">
				</td>
			</tr>
			<tr>
				<td>ตำแหน่ง</td>
				<td>
					<c:if test="${employee.position == 1 }">
						<select name="position" required="required">
							<option value="1" selected="selected">1: ผู้จัดการร้าน</option>
							<option value="2">2: พ่อครัว</option>
							<option value="3">3: พนักงานเสริฟ์</option>
							<option value="4">4: พนักงานขับรถ</option>
						</select>
					</c:if>
					<c:if test="${employee.position == 2 }">
						<select name="position" required="required">
							<option value="1">1: ผู้จัดการร้าน</option>
							<option value="2" selected="selected">2: พ่อครัว</option>
							<option value="3">3: พนักงานเสริฟ์</option>
							<option value="4">4: พนักงานขับรถ</option>
						</select>
					</c:if>
					<c:if test="${employee.position == 3 }">
						<select name="position" required="required">
							<option value="1">1: ผู้จัดการร้าน</option>
							<option value="2">2: พ่อครัว</option>
							<option value="3" selected="selected">3: พนักงานเสริฟ์</option>
							<option value="4">4: พนักงานขับรถ</option>
						</select>
					</c:if>
					<c:if test="${employee.position == 4 }">
						<select name="position" required="required">
							<option value="1">1: ผู้จัดการร้าน</option>
							<option value="2">2: พ่อครัว</option>
							<option value="3">3: พนักงานเสริฟ์</option>
							<option value="4" selected="selected">4: พนักงานขับรถ</option>
						</select>
					</c:if>
					<c:if test="${employee == null }">
						<select name="position" required="required">
							<option value="1">1: ผู้จัดการร้าน</option>
							<option value="2">2: พ่อครัว</option>
							<option value="3">3: พนักงานเสริฟ์</option>
							<option value="4">4: พนักงานขับรถ</option>
						</select>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>เงินเดือน</td>
				<td>
					<input type="text" name="salary" placeholder="enter salary" 
					pattern="[0-9]{1,}" title="ป้อนเป็นตัวเลขเท่านั้น" 
					value="${employee.salary }">
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="แก้ไข">
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