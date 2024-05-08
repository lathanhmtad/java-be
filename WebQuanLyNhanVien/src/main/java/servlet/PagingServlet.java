package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

import java.io.IOException;
import java.util.ArrayList;

import dao.EmployeeDAO;


public class PagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PagingServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String index = request.getParameter("index");
		if(index == null) {
			index = "1";
		}
		
		int currentPage = Integer.parseInt(index);
		
		
		ArrayList<Employee> list = EmployeeDAO.getInstance().getPaging(currentPage);
		request.setAttribute("listE", list);
		request.setAttribute("currentPage", currentPage);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
