package com.ndd.dao;

import com.ndd.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel> {
	UserModel findOneByUsernameAndPassword(String username, String password, Integer status);
}