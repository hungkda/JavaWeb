<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="_navTop.jsp"></jsp:include>
	<section class="container">
		<h3>Edit Employee</h3>
		<p style="color: red;">${errorString}</p>
		<c:if test="${empty e}">
			<a href="EmployeeList"> Quay lại</a>
		</c:if>
		<c:if test="${not empty e}">
			<form method="POST" action="${pageContext.request.contextPath}/EmployeeEdit">
				<table class="table table-bordered">
					<tr>
						<td>Mã nhân viên</td>
						<td><input type="text" name="empId" value="${e.empId}" readOnly/></td>
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
									<c:choose>
										<c:when test="${e.department.deptId == d.deptId}">
											<option value="${d.deptId}" selected>${d.deptId}</option>
										</c:when>
										<c:otherwise>
											<option value="${d.deptId}" >${d.deptId}</option>
										</c:otherwise>
									</c:choose>
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
									<c:choose>
										<c:when test="${e.employee.empId == emp.empId}">
											<option value="${emp.empId}" selected>${emp.empId}</option>
										</c:when>
										<c:otherwise>
											<option value="${emp.empId}" >${emp.empId}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
						<input type="submit" value="Ghi lại" class="btn btn-success">
							<a href="EmployeeList" class="btn btn-danger"> Quay lại</a>
						</td>
					</tr>
				</table>
			</form>
		</c:if>
	</section>
</body>
</html>