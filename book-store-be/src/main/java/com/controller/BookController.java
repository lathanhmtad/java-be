package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.impl.BookDAOImpl;
import com.dao.impl.BookImageDAOImpl;
import com.dao.impl.CategoryDAOImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.model.Book;
import com.model.BookImage;
import com.model.Category;
import com.utils.ImageUtil;

@WebServlet("/api/v1/books")
@MultipartConfig
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get all books from database
		BookDAOImpl bookDAOImpl = new BookDAOImpl();
		List<Book> books = bookDAOImpl.getAll();

		// create json array save info book
		JsonArray bookArray = new JsonArray();

		// browse the list of books and create a json object to hold the info of each book
		for (Book book : books) {
			JsonObject bookObj = new JsonObject();

			bookObj.addProperty("id", book.getId());
			bookObj.addProperty("name", book.getName());
			bookObj.addProperty("author", book.getAuthor());
			bookObj.addProperty("languages", book.getLanguages());
			bookObj.addProperty("length", book.getLength());
			bookObj.addProperty("price", book.getPrice());
			bookObj.addProperty("description", book.getDescription());

			// create a json array object to hold a list of books images
			JsonArray imageArray = new JsonArray();
			List<BookImage> images = book.getImages();
			for (BookImage bookImage : images) {
				JsonObject imageObj = new JsonObject();

				byte[] imageData = ImageUtil.decompressImage(bookImage.getImageData());
				String base64ImageData = Base64.getEncoder().encodeToString(imageData);

				imageObj.addProperty("id", bookImage.getId());
				imageObj.addProperty("data", base64ImageData);
				imageObj.addProperty("type", bookImage.getType());
				imageObj.addProperty("name", bookImage.getName());

				imageArray.add(imageObj);
			}

			// add an array containing the list of images to the book object
			bookObj.add("images", imageArray);

			// add object book to array
			bookArray.add(bookObj);
		}

		// set the response content type and character encoding
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().print(bookArray);
	}

	// create book
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String author = request.getParameter("author");
		Long categoryId = Long.parseLong(request.getParameter("category"));
		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
		Category category = categoryDAOImpl.getCategoryById(categoryId);
		double price = Double.parseDouble(request.getParameter("price"));
		String languages = request.getParameter("languages");
		int length = Integer.parseInt(request.getParameter("length"));
		String description = request.getParameter("description");

		// Create a book object
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setCategory(category);
		book.setPrice(price);
		book.setLanguages(languages);
		book.setLength(length);
		book.setDescription(description);

		// save the book to the database
		BookDAOImpl bookDAOImpl = new BookDAOImpl();
		boolean flag = bookDAOImpl.insertBook(book);

		// set the response content type and character encoding
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// insert successfully
		if (flag) {
			// create a json book object
			JsonObject bookObj = new JsonObject();
			bookObj.addProperty("id", book.getId());
			bookObj.addProperty("name", book.getName());
			bookObj.addProperty("author", book.getAuthor());
			bookObj.addProperty("languages", book.getLanguages());
			bookObj.addProperty("length", book.getLength());
			bookObj.addProperty("price", book.getPrice());
			bookObj.addProperty("description", book.getDescription());
			
			
			// Get the images upload from client
			Collection<Part> parts = request.getParts();
			
			BookImageDAOImpl bookImageDAOImpl = new BookImageDAOImpl();
			
			JsonArray imageArray = new JsonArray();

			for (Part part : parts) {
				if (part.getName().equals("images")) {
					JsonObject imageObj = new JsonObject();
					
					BookImage bookImage = new BookImage();
					bookImage.setBook(book);
					
					// set the original file name
					bookImage.setName(part.getSubmittedFileName());
					bookImage.setType(part.getContentType());

					// set the content of the file
					InputStream inputStream = part.getInputStream();
					byte[] content = ImageUtil.compressImage(inputStream.readAllBytes());
					bookImage.setImageData(content);

					bookImageDAOImpl.insertBookImage(bookImage);
					
					byte[] imageData = ImageUtil.decompressImage(bookImage.getImageData());
					String base64ImageData = Base64.getEncoder().encodeToString(imageData);
					
					imageObj.addProperty("id", bookImage.getId());
					imageObj.addProperty("data", base64ImageData);
					imageObj.addProperty("type", bookImage.getType());
					imageObj.addProperty("name", bookImage.getName());
					
					imageArray.add(imageObj);
				}
			}
			
			// add object book to array
			bookObj.add("images", imageArray);

			// successful create book
			response.setStatus(HttpServletResponse.SC_CREATED);
			response.getWriter().print(bookObj);

		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().println("{\"error\": \"Tạo sách thất bại có lỗi xảy ra trên server\"}");
		}

	}

}
