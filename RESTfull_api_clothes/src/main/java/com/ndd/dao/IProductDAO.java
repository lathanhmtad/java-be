package com.ndd.dao;

import java.util.List;

import com.ndd.model.Product;

public interface IProductDAO extends IGenericDAO<Product> {
	List<Product> findAll();
}
