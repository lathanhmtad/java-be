package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import utils.DateConverter;

import java.io.IOException;
import java.util.Date;

import dao.EmployeeDAO;

public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddEmployeeServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String fullName = request.getParameter("fname");
		Date dob = DateConverter.parseDateString(request.getParameter("birthday"));
		String address = request.getParameter("address");
		Date workStartDate = DateConverter.parseDateString(request.getParameter("workStartDate"));
		Date workEndDate = DateConverter.parseDateString(request.getParameter("workEndDate"));
		double salary = Double.parseDouble(request.getParameter("salary"));
		int workId = Integer.parseInt(request.getParameter("jobs"));

		Employee newEmployee = new Employee();
		newEmployee.setFullName(fullName);
		newEmployee.setDob(dob);
		newEmployee.setAddress(address);
		newEmployee.setWorkStartDate(workStartDate);
		newEmployee.setWorkEndDate(workEndDate);
		newEmployee.setSalary(salary);
		newEmployee.setWork(workId);
		
		
		int flag = EmployeeDAO.getInstance().insert(newEmployee);
		if(flag > 0) {
			System.out.println("Chèn dữ liệu thành công");
			request.setAttribute("employeeAddStatus", "Thêm mới nhân viên thành công");
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
		else {
			System.out.println("Chèn dữ liệu thất bại");
			request.setAttribute("employeeAddStatus", "Không thể thêm nhân viên này");
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
	}

}
