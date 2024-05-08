package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

import java.io.IOException;

import dao.EmployeeDAO;


public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteEmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		Employee e = new Employee();
		e.setId(id);
		
		int result = EmployeeDAO.getInstance().delete(e);
		
		if(result > 0) {
			response.sendRedirect("paging?index=" + currentPage);
		}
		
	}


}
