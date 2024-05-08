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
import com.utils.EmailUtil;
import com.utils.RandomUtil;

@WebServlet("/api/v1/register")
@MultipartConfig
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// create customer data access object
		CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();

		// get the email parameter to check if it exists in the database
		String email = request.getParameter("email");
		boolean isEmailExists = customerDAOImpl.checkEmailExists(email);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");

		
		if (isEmailExists) { // email already exists send feedback and stop program
			response.setStatus(HttpServletResponse.SC_CONFLICT);
			response.getWriter().println("{\"error\": \"Email đã được sử dụng vui lòng sử dụng email khác.\"}");

			return;
		} 
		else { 
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String verificationCode = RandomUtil.getRandomNumber(); 

			Customer customer = new Customer();
			customer.setUsername(username);
			customer.setEmail(email);
			customer.setPassword(password);
			customer.setVerificationCode(verificationCode);
			
			// save customer to database
			boolean flag = customerDAOImpl.insertCustomer(customer);
			
			
			if (flag) { // save to database successfully
				
				// send email
				EmailUtil.sendEmail(email, "Xin chào.", EmailUtil.getContent(customer));
				
				// save email to session
				request.getSession().setAttribute("email", email);
				
				
				response.setStatus(HttpServletResponse.SC_OK);
				
			}
			else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				response.getWriter().println("{\"error\": \"Lỗi máy chủ vui lòng thử lại sau.\"}");
			}
		}

	}

}
