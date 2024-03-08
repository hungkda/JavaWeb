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
	
		<h3>Category List</h3>
		<p style="color: red;">${errorString}</p>
		<table class="table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>Mã danh mục</th>
					<th>Tên danh mục</th>
					<th>Tác vụ</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categoryList}" var="category">
					<tr>
						<td>${category.categoryId}</td>
						<td>${category.categoryName}</td>
						<td>
							<a class="btn btn-success" href="CategoryEdit?categoryId=${category.categoryId}">Edit</a>
							<a class="btn btn-danger" href="CategoryDelete?categoryId=${category.categoryId}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="CategoryCreate">Create Category</a>
	</section>
</body>
</html>