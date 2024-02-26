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
	<section class="container">
		<h3>Product List</h3>
		<p style="color: red;">${errorString}</p>
		<table class="table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>Mã sản phẩm</th>
					<th>Tên sản phẩm</th>
					<th>Số lượng</th>
					<th>Đơn giá</th>
					<th>Ảnh</th>
					<th>Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.maSP_2110900052}</td>
						<td>${product.tenSP_2110900052}</td>
						<td>${product.donGia_2110900052}</td>
						<td>${product.soLuong_2110900052}</td>
						<td><img style="width: 50px" src="./images/${product.anh_2110900052}"/></td>
						<td>
							<a class="btn btn-success" href="NguyenManhHung_ProductEdit?maSP=${product.maSP_2110900052}">Edit</a>
							<a class="btn btn-danger" href="NguyenManhHung_ProductDelete?maSP=${product.maSP_2110900052}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="NguyenManhHung_ProductCreate">Create Product</a>
	</section>

</body>
</html>