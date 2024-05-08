package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.CustomerDAOImpl;
import com.model.Customer;

@WebServlet("/api/v1/verify")
@MultipartConfig
public class VerificationCodeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public VerificationCodeController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get email from session
		String email = (String) request.getSession().getAttribute("email");
		
		// get the verification code parameter
		String code = request.getParameter("code");
		
		System.out.println(email);
		System.out.println(code);
		
		// Verify the code with the registered email 
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
		Customer customer = customerDAOImpl.isValidVerificationCode(email, code);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		// successful authentication
		if(customer != null) {
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.getWriter().println("{\"success\": \"Đăng ký thành công. Vui lòng đăng nhập để sử dụng.\"}");
		}
		else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().println("{\"error\": \"Mã xác thực không chính xác.\"}");
		}
	}

}
