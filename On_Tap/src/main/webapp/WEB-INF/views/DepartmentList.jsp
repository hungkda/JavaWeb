<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_navTop.jsp"></jsp:include>
	<section class="container">
	
		<h3>Product List</h3>
		<p style="color: red;">${errorString}</p>
		<table class="table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>Mã phòng</th>
					<th>Phòng - NO</th>
					<th>Tên phòng</th>
					<th>Địa điểm</th>
					<th>Tác vụ</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${departmentList}" var="d">
					<tr>
						<td>${d.deptId}</td>
						<td>${d.deptNo}</td>
						<td>${d.deptName}</td>
						<td>${d.location}</td>
						<td>
							<a class="btn btn-success" href="DepartmentEdit?deptId=${d.deptId}">Edit</a>
							<a class="btn btn-danger" href="DepartmentDelete?deptId=${d.deptId}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="DepartmentCreate">Create Department</a>
	</section>

</body>
</html>