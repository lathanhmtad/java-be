package com.ndd.services.impl;

import javax.inject.Inject;

import com.ndd.dao.IUserDAO;
import com.ndd.model.UserModel;
import com.ndd.services.IUserService;

public class UserServiceImpl implements IUserService {

	@Inject
	IUserDAO dao;
	
	@Override
	public UserModel findOneByUsernameAndPassword(String username, String password, Integer status) {
		return dao.findOneByUsernameAndPassword(username, password, status);
	}

}
