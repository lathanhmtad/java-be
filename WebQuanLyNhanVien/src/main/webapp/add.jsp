<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dao.WorkDAO"%>
<%@page import="model.Work"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm mới nhân viên</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<div class="container">
		<a href="paging?index=1">Về trang chủ</a>

		<h1>Thêm mới nhân viên</h1>
		<h2 style="color: red">
			<%
			String status = (String) request.getAttribute("employeeAddStatus");
			if (status != null) {
			%>
			<%=status%>
			<%
			}
			%>
		</h2>

		<form method="POST" action="add-employee">
			<div class="form-group">
				<label for="fname">Họ và tên</label> <input type="text" id="fname"
					name="fname">
			</div>
			<div class="form-group">
				<label for="birthday">Ngày sinh</label> <input type="date"
					id="birthday" name="birthday">
			</div>
			<div class="form-group">
				<label for="address">Địa chỉ</label> <input type="text" id="address"
					name="address">
			</div>
			<div class="form-group">
				<label for="workStartDate">Ngày bắt đầu làm việc</label> <input
					type="date" id="workStartDate" name="workStartDate">
			</div>
			<div class="form-group">
				<label for="workEndDate">Ngày kết thúc làm việc</label> <input
					type="date" id="workEndDate" name="workEndDate">
			</div>
			<div class="form-group">
				<label for="salary">Lương</label> <input type="number" id="salary"
					name="salary">
			</div>
			<div class="form-group">
				<label for="jobs">Tên công việc</label>
				<%
				ArrayList<Work> works = WorkDAO.getInstance().getList();
				%>
				<select id="jobs" name="jobs">
					<%
					for (Work item : works) {
					%><option value="<%=item.getId()%>"><%=item.getName()%></option>
					<%
					}
					%>
				</select>
				<%

				%>

			</div>
			<button type="submit">Thêm mới</button>
		</form>
	</div>
</body>
</html>