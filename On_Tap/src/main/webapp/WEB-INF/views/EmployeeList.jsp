<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
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
					<th>Mã nhân viên</th>
					<th>Tên nhân viên</th>
					<th>Nhân viên - NO</th>
					<th>Ngày thuê</th>
					<th>Mã phòng</th>
					<th>Công việc</th>
					<th>Lương</th>
					<th>Mã MNG</th>
					<th>Tác vụ</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employeeList}" var="e">
					<tr>
						<td>${e.empId}</td>
						<td>${e.empName}</td>
						<td>${e.empNo}</td>
						<td>${e.hireDate}</td>
						<td>${e.department.deptId}</td>
						<td>${e.job}</td>
						<td>${e.salary}</td>
						<td>${e.employee.empId}</td>
						<td>
							<a class="btn btn-success" href="EmployeeEdit?empId=${e.empId}">Edit</a>
							<a class="btn btn-danger" href="EmployeeDelete?empId=${e.empId}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="EmployeeCreate">Create Employee</a>
	</section>

</body>
</html>