package com.dao;

import java.util.List;

import com.model.Cart;

public interface ICartDAO {
	boolean save(Cart cart);
	
	boolean remove(Long id);
	
	boolean update(Cart newCart);
	
	List<Cart> getAllCarts();
}
