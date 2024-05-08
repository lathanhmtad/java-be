package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	private String address;
	private String phone;
	private String verificationCode;
	private boolean isVerified;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
}
