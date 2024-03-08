<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<section class="container">
		<h3>Edit Category</h3>
		<p style="color: red;">${errorString}</p>
		<c:if test="${empty category}">
			<a href="CategoryList"> Quay lại</a>
		</c:if>
		<c:if test="${not empty category}">
			<form method="POST" action="${pageContext.request.contextPath}/CategoryEdit">
				<table class="table table-bordered">
					<tr>
						<td>Mã SP</td>
						<td><input type="text" name="categoryId" value="${category.categoryId}" readOnly/></td>
					</tr>
					<tr>
						<td>Phòng - NO</td>
						<td><input type="text" name="categoryName" value="${category.categoryName}" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
						<input type="submit" value="Ghi lại" class="btn btn-success">
							<a href="CategoryList" class="btn btn-danger"> Quay lại</a>
						</td>
					</tr>
				</table>
			</form>
		</c:if>
	</section>
</body>
</html>