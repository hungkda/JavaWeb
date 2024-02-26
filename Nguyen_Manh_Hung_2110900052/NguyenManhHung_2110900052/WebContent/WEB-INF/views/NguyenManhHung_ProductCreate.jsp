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
<section class="container">
		<h3>Create Product</h3>
		<p style="color: red">${errorString}</p>
		<form method="post" action="${pageContext.request.contextPath}/NguyenManhHung_ProductCreate">
			<table class="table table-bordered">
					<tr>
						<td>Mã SP</td>
						<td><input type="text" name="maSP_2110900052" value="${product.maSP_2110900052}" /></td>
					</tr>
					<tr>
						<td>Tên SP</td>
						<td><input type="text" name="tenSP_2110900052" value="${product.tenSP_2110900052}" /></td>
					</tr>
					<tr>
						<td>Số Lượng</td>
						<td><input type="text" name="soLuong_2110900052" value="${product.soLuong_2110900052}" /></td>
					</tr>
					<tr>
						<td>Đơn giá</td>
						<td><input type="text" name="donGia_2110900052" value="${product.donGia_2110900052}" /></td>
					</tr>
					<tr>
						<td>Ảnh</td>
						<td><input type="text" name="anh_2110900052" value="${product.anh_2110900052}" /></td>
					</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lại" class="btn btn-success">
						<a href="NguyenManhHung_ProductList" class="btn btn-danger">Quay lại</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>