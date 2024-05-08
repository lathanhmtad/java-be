<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nhân viên</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>

	<jsp:useBean id="eDAO" class="dao.EmployeeDAO" scope="request"></jsp:useBean>

	<div class="container">
		<h1>Quản lý nhân viên</h1>
		<a href="add.jsp">Thêm mới nhân viên</a> <a href="">Tải lại</a>
		<h2>Tìm kiếm nhân viên</h2>

		<form>
			<input placeholder="Tìm kiếm..." />
			<button type="submit">Tìm kiếm</button>
		</form>

		<!-- Table show result when search -->
		<table style="width: 100%">
			<tr>
				<th>Mã nhân viên</th>
				<th>Họ tên</th>
				<th>Ngày sinh</th>
				<th>Địa chỉ</th>
				<th>Ngày bắt đầu làm việc</th>
				<th>Ngày kết thúc làm việc</th>
				<th>Lương</th>
				<th>Tên công việc</th>
			</tr>
		</table>

		<h2 style="margin-top: 32px">Danh sách nhân viên</h2>

		<!-- Table show result when load web -->
		<table style="width: 100%">
			<tr>
				<th>Họ tên</th>
				<th>Ngày sinh</th>
				<th>Địa chỉ</th>
				<th>Ngày bắt đầu làm việc</th>
				<th>Ngày kết thúc làm việc</th>
				<th>Lương</th>
				<th>Tên công việc</th>
				<th></th>
			</tr>

			<c:forEach items='${listE}' var='item'>
				<tr>
					<td>${item.fullName }</td>
					<td>${item.dob }</td>
					<td>${item.address }</td>
					<td>${item.workStartDate }</td>
					<td>${item.workEndDate }</td>
					<td>${item.salary }</td>
					<td>${item.work.name }</td>
					<td style="display: flex; justify-content: space-evenly;"><a
						href="delete?id=${item.id}&page=${currentPage}">Xóa</a> / <a href="edit.jsp?id=${item.id}&page=${currentPage}">Chỉnh sửa</a></td>
				</tr>
			</c:forEach>

		</table>

		<ul>
			<c:forEach begin="1" end="${eDAO.getNumberPage()}" var="i">
				<li><a class="${currentPage == i ? "
					active" : ""}" href="paging?index=${i }">${i }</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>