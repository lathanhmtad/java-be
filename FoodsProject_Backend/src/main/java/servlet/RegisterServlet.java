package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import dao.UserDAO;

@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User us = new User();
		us.setFullName(fullname);
		us.setEmail(email);
		us.setPassword(password);
		us.setCreateAt(new Date(System.currentTimeMillis()));
		
		System.out.println(us);

		UserDAO userDAO = new UserDAO();
		us = userDAO.insert(us); // get full info of us after insert
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if (us != null) { // sign up success
			Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
			String usJSON = gson.toJson(us);
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.getWriter().write(usJSON);
		} else { // sign up failed
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("message", "Đăng ký không thành công có lỗi xảy ra trên server");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write(jsonObject.toString());
		}

	}

}
