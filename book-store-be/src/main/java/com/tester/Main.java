package com.tester;

import java.util.List;

import com.dao.impl.BookDAOImpl;
import com.model.Book;
import com.model.BookImage;

//import com.dao.impl.CategoryDAOImpl;
//import com.model.Category;

//import com.model.Customer;
//import com.utils.EmailUtil;

//import com.utils.RandomUtil;

//import com.dao.impl.RoleDAOImpl;
//import com.model.Role;

//import com.dao.impl.CustomerDAOImpl;
//import com.model.Customer;

public class Main {
	public static void main(String[] args) {
//		Role admin = new Role();
//		admin.setName("admin");
//		admin.setDescription("Người điều hành trang web");
//		
//		Role seller = new Role();
//		seller.setName("Người bán");
//		seller.setDescription("Người được quyền bán và mua sản phẩm của người khác");
//		
//		Role buyer = new Role();
//		buyer.setName("Người mua");
//		buyer.setDescription("Người đăng ký tài khoản và mua hàng");
//		
//		RoleDAOImpl roleDAOImpl = new RoleDAOImpl();
//		roleDAOImpl.insertRole(admin);
//		roleDAOImpl.insertRole(seller);
//		roleDAOImpl.insertRole(buyer);
		
//		Customer cus = new Customer();
//		cus.setUsername("Nguyễn Đăng Duy");
//		cus.setEmail("abc@gmail.com");
//		
//		CustomerDAOImpl dao = new CustomerDAOImpl();
//		boolean f = dao.insertCustomer(cus);
//		
//		System.out.println(f);
//		System.out.println(cus);
		
//		Customer cus = new Customer();
//		cus.setUsername("Nguyễn Đăng Duy");
//		cus.setEmail("abc@gmail.com");
//		boolean flag = EmailUtil.sendEmail("21115053120211@sv.ute.udn.vn", "Test send email 2", EmailUtil.getContent(cus));
//		
//		System.out.println(flag);
		
//		Category c = new Category();
//		c.setName("Sách truy hồn");
//		
//		CategoryDAOImpl dao = new CategoryDAOImpl();
//		boolean f = dao.insertCategory(c);
//		System.out.println(f);
		
		BookDAOImpl bookDAOImpl = new BookDAOImpl();
		List<Book> books = bookDAOImpl.getAll();
		
		for (Book book : books) {
			List<BookImage> images = book.getImages();
			System.out.println("Tên sách: " + book.getName());
			for (BookImage image : images) {
				System.out.println("----------Hình ảnh: " + image.getName());
			}
//			System.out.println(book.getName());
			
			
		}
	}
}
