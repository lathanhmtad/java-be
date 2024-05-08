package com.ndd.services;

import com.ndd.model.UserModel;

public interface IUserService {
	UserModel findOneByUsernameAndPassword(String username, String password, Integer status);
}
