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
		<h3>Create Customer</h3>
		<p style="color: red">${errorString}</p>
		<form method="post" action="${pageContext.request.contextPath}/createCustomer">
			<table class="table table-bordered">
					<tr>
						<td>CusUser</td>
						<td><input type="text" name="cusUser" value="${customer.cusUser}" /></td>
					</tr>
					<tr>
						<td>CusPass</td>
						<td><input type="text" name="cusPass" value="${customer.cusPass}" /></td>
					</tr>
					<tr>
						<td>CusName</td>
						<td><input type="text" name="cusName" value="${customer.cusName}" /></td>
					</tr>
					<tr>
						<td>CusPhone</td>
						<td><input type="text" name="cusPhone" value="${customer.cusPhone}" /></td>
					</tr>
					<tr>
						<td>CusAdd</td>
						<td><input type="text" name="cusAdd" value="${customer.cusAdd}" /></td>
					</tr>
					<tr>
						<td>CusEmail</td>
						<td><input type="text" name="cusEmail" value="${customer.cusEmail}" /></td>
					</tr>
					<tr>
						<td>CusFacebook</td>
						<td><input type="text" name="cusFacebook" value="${customer.cusFacebook}" /></td>
					</tr>
					<tr>
						<td>CusSkyper</td>
						<td><input type="text" name="cusSkyper" value="${customer.cusSkyper}" /></td>
					</tr>
					<tr>
						<td>CusStatus</td>
						<td><input type="text" name="cusStatus" value="${customer.cusStatus}" /></td>
					</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" name="Ghi lại" class="btn btn-success">
						<a href="listCustomer" class="btn btn-danger">Quay lại</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>