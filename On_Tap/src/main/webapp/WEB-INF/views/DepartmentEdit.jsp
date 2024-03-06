<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Department</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_navTop.jsp"></jsp:include>
	<section class="container">
		<h3>Edit Department</h3>
		<p style="color: red;">${errorString}</p>
		<c:if test="${empty department}">
			<a href="DepartmentList"> Quay lại</a>
		</c:if>
		<c:if test="${not empty department}">
			<form method="POST" action="${pageContext.request.contextPath}/DepartmentEdit">
				<table class="table table-bordered">
					<tr>
						<td>Mã SP</td>
						<td><input type="text" name="deptId" value="${department.deptId}" readOnly/></td>
					</tr>
					<tr>
						<td>Phòng - NO</td>
						<td><input type="text" name="deptNo" value="${department.deptNo}" /></td>
					</tr>
					<tr>
						<td>Tên phòng</td>
						<td><input type="text" name="deptName" value="${department.deptName}" /></td>
					</tr>
					<tr>
						<td>Địa điểm</td>
						<td><input type="text" name="location" value="${department.location}" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
						<input type="submit" value="Ghi lại" class="btn btn-success">
							<a href="DepartmentList" class="btn btn-danger"> Quay lại</a>
						</td>
					</tr>
				</table>
			</form>
		</c:if>
	</section>
</body>
</html>