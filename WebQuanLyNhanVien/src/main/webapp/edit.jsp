<%@page import="dao.EmployeeDAO"%>
<%@page import="model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dao.WorkDAO"%>
<%@page import="model.Work"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	
	int currentPage = Integer.parseInt(request.getParameter("page"));

	Employee e = EmployeeDAO.getInstance().getObject(id);
	%>

	<div class="container">

		<h1>Chỉnh sửa nhân viên</h1>

		<form method="POST" action="edit">
			<input type="hidden" name="eid" value="<%=e.getId()%>"/>
			<input type="hidden" name="page" value="<%=currentPage%>"/>
		
			<div class="form-group">
				<label for="fname">Họ và tên</label> <input type="text" id="fname"
					name="fname" value="<%=e.getFullName()%>">
			</div>
			<div class="form-group">
				<label for="birthday">Ngày sinh</label> <input type="date"
					id="birthday" name="birthday" value="<%=e.getDob()%>">
			</div>
			<div class="form-group">
				<label for="address">Địa chỉ</label> <input type="text" id="address"
					name="address" value="<%=e.getAddress()%>">
			</div>
			<div class="form-group">
				<label for="workStartDate">Ngày bắt đầu làm việc</label> <input
					type="date" id="workStartDate" name="workStartDate"
					value="<%=e.getWorkStartDate()%>">
			</div>
			<div class="form-group">
				<label for="workEndDate">Ngày kết thúc làm việc</label> <input
					type="date" id="workEndDate" name="workEndDate"
					value="<%=e.getWorkEndDate()%>">
			</div>
			<div class="form-group">
				<label for="salary">Lương</label> <input type="number" id="salary"
					name="salary" value="<%=e.getSalary()%>">
			</div>
			<div class="form-group">
				<label for="jobs">Tên công việc</label>
				<%
				ArrayList<Work> works = WorkDAO.getInstance().getList();
				%>
				<select id="jobs" name="jobs">
					<option value="<%=e.getWork().getName()%>"><%=e.getWork().getName() %></option>
					<%
					for (Work item : works) {
						if (item.getId() != e.getWork().getId()) {
					%><option value="<%=item.getId()%>"><%=item.getName()%></option>
					<%
					}
					}
					%>
				</select>
				<%

				%>

			</div>
			<button type="submit">Chỉnh sửa</button>
		</form>
	</div>
</body>
</html>