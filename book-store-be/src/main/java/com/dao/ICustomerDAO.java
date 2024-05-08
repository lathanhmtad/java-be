package com.dao;

import com.model.Customer;

public interface ICustomerDAO {
	 boolean insertCustomer(Customer customer);
	
	 Customer getCustomerById(Long id);
	
	 boolean checkEmailExists(String email);
	
	 Customer isValidVerificationCode(String email, String code);
	 Customer getCustomerByEmailAndPassword(String email, String password);
}
