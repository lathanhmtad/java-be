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
import dao.WorkDAO;


public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditEmployeeServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		int id = Integer.parseInt(request.getParameter("eid"));
		String fullName = request.getParameter("fname");
		Date dob = DateConverter.parseDateString(request.getParameter("birthday"));
		String address = request.getParameter("address");
		Date workStartDate = DateConverter.parseDateString(request.getParameter("workStartDate"));
		Date workEndDate = DateConverter.parseDateString(request.getParameter("workEndDate"));
		double salary = Double.parseDouble(request.getParameter("salary"));
		int workId = Integer.parseInt(request.getParameter("jobs"));

		Employee newEmployee = new Employee();
		newEmployee.setId(id);
		newEmployee.setFullName(fullName);
		newEmployee.setDob(dob);
		newEmployee.setAddress(address);
		newEmployee.setWorkStartDate(workStartDate);
		newEmployee.setWorkEndDate(workEndDate);
		newEmployee.setSalary(salary);
		newEmployee.setWork(workId);
		
		int flag = EmployeeDAO.getInstance().update(newEmployee);
		
		if(flag > 0) {
			response.sendRedirect("paging?index=" + currentPage);
		}
	}

}
