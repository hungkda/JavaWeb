<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
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
		<h3>Create Product</h3>
		<p style="color: red">${errorString}</p>
		<form method="post" action="${pageContext.request.contextPath}/EmployeeCreate">
			<table class="table table-bordered">
					<tr>
						<td>Mã nhân viên</td>
						<td><input type="text" name="empId" value="${e.empId}"/></td>
					</tr>
					<tr>
						<td>Tên nhân viên</td>
						<td><input type="text" name="empName" value="${e.empName}" /></td>
					</tr>
					<tr>
						<td>Nhân viên - NO</td>
						<td><input type="text" name="empNo" value="${e.empNo}" /></td>
					</tr>
					<tr>
						<td>Mã phòng</td>
						<td>
							<select name="department">
								<c:forEach items="${departmentList}" var="d">
									<option value="${d.deptId}">${d.deptId}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>Công việc</td>
						<td><input type="text" name="job" value="${e.job}" /></td>
					</tr>
					<tr>
						<td>Lương</td>
						<td><input type="text" name="salary" value="${e.salary}" /></td>
					</tr>
					<tr>
						<td>Mã MNG</td>
						<td>
							<select name="employee">
								<c:forEach items="${employeeList}" var="emp">
									<option value="${emp.empId}">${emp.empId}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Thêm mới" class="btn btn-success">
						<a href="EmployeeList" class="btn btn-danger">Quay lại</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>