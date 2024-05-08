package com.ndd.services.impl;

import java.util.List;

import javax.inject.Inject;

import com.ndd.dao.IProductDAO;
import com.ndd.model.Product;
import com.ndd.services.IProductService;

public class ProductServiceImpl implements IProductService {

	@Inject
	IProductDAO dao;
	
	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

}
