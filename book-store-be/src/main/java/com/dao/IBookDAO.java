package com.dao;

import java.util.List;

import com.model.Book;

public interface IBookDAO {
	 boolean insertBook(Book b);
	
	 List<Book> getAll();
}
