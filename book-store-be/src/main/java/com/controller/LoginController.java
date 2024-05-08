package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.CustomerDAOImpl;
import com.google.gson.Gson;
import com.model.Customer;

@WebServlet("/api/v1/login")
@MultipartConfig
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		Customer customer = customerDAOImpl.getCustomerByEmailAndPassword(email, password);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		// customer exists
		if(customer != null) {
			// verified account
			if(customer.isVerified()) {
				Gson gson = new Gson();
				String customerJson = gson.toJson(customer);
				
				response.setStatus(HttpServletResponse.SC_OK);
				response.getWriter().println(customerJson);
			}
			// unverified account
			else {
				
			}
		}
		else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().println("{\"error\": \"Email hoặc mật khẩu không chính xác.\"}");
		}
	}

}
