<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_navTop.jsp"></jsp:include>
	<section class="container">
		<h3>Create Department</h3>
		<p style="color: red">${errorString}</p>
		<form method="post" action="${pageContext.request.contextPath}/DepartmentCreate">
			<table class="table table-bordered">
					<tr>
						<td>Mã phòng</td>
						<td><input type="text" name="deptId" value="${department.deptId}" /></td>
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
						<a href="DepartmentList" class="btn btn-danger">Quay lại</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>