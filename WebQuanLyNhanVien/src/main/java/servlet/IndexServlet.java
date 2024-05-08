package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

import java.io.IOException;
import java.util.ArrayList;

import dao.EmployeeDAO;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Execute a SQL query to retrieve data from the database
		ArrayList<Employee> employeeList = EmployeeDAO.getInstance().getList();
		
		
		// Set the "employeeList" attribute on the request object
		request.setAttribute("employees", employeeList);

		// Forward the request to the "index.jsp" page
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
