package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.CategoryDAOImpl;
import com.google.gson.Gson;
import com.model.Category;

@WebServlet("/api/v1/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CategoryController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get all category
		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
		List<Category> listC = categoryDAOImpl.getAll();
		
		// convert the list of category to JSON
		Gson gson = new Gson();
		String listCJson = gson.toJson(listC);
		
		// set the response content type and character encoding
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // write the JSON to the response
        response.getWriter().write(listCJson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
