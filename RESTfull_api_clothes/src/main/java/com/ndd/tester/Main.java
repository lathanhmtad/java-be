package com.ndd.tester;

import java.util.List;

import com.ndd.model.Category;
import com.ndd.model.Product;

import model.ndd.dao.impl.CategoryDAOImpl;
import model.ndd.dao.impl.ProductDAOImpl;

public class Main {
	public static void main(String[] args) {
		CategoryDAOImpl cImpl = new CategoryDAOImpl();
		List<Category> listC = cImpl.findAll();
		for (Category category : listC) {
			System.out.println(category);
		}

		System.out.println("------------------------");

		ProductDAOImpl pImpl = new ProductDAOImpl();
		List<Product> listP = pImpl.findAll();
		for (Product p : listP) {
			System.out.println(p);
		}
	}
}
