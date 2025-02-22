package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.impl.CartDAOImpl;
import com.google.gson.Gson;
import com.model.Book;
import com.model.Cart;
import com.model.Customer;

@WebServlet("/api/v1/cart")
@MultipartConfig
public class CartController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Lấy danh sách giỏ hàng từ cơ sở dữ liệu
		CartDAOImpl cartDAOImpl = new CartDAOImpl();
		List<Cart> carts = cartDAOImpl.getAllCarts();

        // Chuyển đổi danh sách giỏ hàng thành JSON và trả về cho client
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(carts));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    	
    	// get info cart from client
    	Long bookId = Long.parseLong(request.getParameter("bookId"));
        String bookName = request.getParameter("name");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        Long customerId = Long.parseLong(request.getParameter("customerId"));
        

        // create object cart and save database
        Cart cart = new Cart();
        cart.setName(bookName);
        cart.setAuthor(author);
        cart.setPrice(price);
        cart.setAmount(amount);
        Book book = new Book();
        book.setId(bookId);
        cart.setBook(book);
        Customer cus = new Customer();
        cus.setId(customerId);
        cart.setCustomer(cus);
        
        Gson gson = new Gson();
        String cartJson = gson.toJson(cart);
        System.out.println(cartJson);
        
        
        response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
        
//        CartDAOImpl cartDAOImpl = new CartDAOImpl();
//        boolean f = cartDAOImpl.save(cart);
        boolean f = true;
        
        if(f) {
        	// response successfully to client
        	response.setStatus(HttpServletResponse.SC_CREATED);
			response.getWriter().print("{\"success\": \"Add cart successfully\"}");
        } else {
        	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().print("{\"error\": \"Failed add cart\"}");
        }
    }

}

