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
		<h3>Customer List</h3>
		<p style="color: red;">${errorString}</p>
		
		<form action="" method="post">
			<label>Nhập cusUser muốn tìm: </label>
			<input type=text name="keyword" value=""/>
			<input type="submit" value="Search" />
		</form>
		
		<table class="table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>CusID</th>
					<th>CusUser</th>
					<th>CusPass</th>
					<th>CusName</th>
					<th>CusPhone</th>
					<th>CusAdd</th>
					<th>CusEmail</th>
					<th>CusFacebook</th>
					<th>CusSkyper</th>
					<th>CusStatus</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listCustomer}" var="customer" >
					<tr>
						<td>${customer.cusId}</td>
						<td>${customer.cusUser}</td>
						<td>${customer.cusPass}</td>
						<td>${customer.cusName}</td>
						<td>${customer.cusPhone}</td>
						<td>${customer.cusAdd}</td>
						<td>${customer.cusEmail}</td>
						<td>${customer.cusFacebook}</td>
						<td>${customer.cusSkyper}</td>
						<td>${customer.cusStatus}</td>
						<td>
							<a href="editCustomer?code=${customer.cusId}">Edit</a>
						</td>
						<td>
							<a href="deleteCustomer?code=${customer.cusId}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="createCustomer" >Create Customer</a>
	</section>
</body>
</html>