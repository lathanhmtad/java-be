package com.ndd.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ndd.model.ProductModel;
import com.ndd.utils.FormUtil;

@WebServlet("/admin-products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductModel model = FormUtil.toModel(ProductModel.class, request);
		String view = "";
		
		
		if(model.getType().equals("list")) {
			// show view list product
			view = "/views/admin/product_management.jsp";
		}
		else if(model.getType().equals("add")) {
			// show view add product
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
