package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dao.RoleDAO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id")
	private int id;

	@Column(name = "u_fullname")
	private String fullName;

	@Column(name = "u_email", unique = true)
	private String email;

	@Column(name = "u_phone")
	private String phone;

	@Column(name = "u_address")
	private String address;

	@Column(name = "u_password")
	private String password;

	@Column(name = "u_create_at")
	private Date createAt;

	@Column(name = "u_update_at")
	private Date updateAt;

	@ManyToOne
	@JoinColumn(name = "r_id")
	private Role role;

	public User() {
		// set the default role as user when creating the User object
		RoleDAO roleDAO = new RoleDAO();
		this.role = new Role();
		this.role.setId("user"); 
		role = roleDAO.getO(role); // get full data

	}

}
