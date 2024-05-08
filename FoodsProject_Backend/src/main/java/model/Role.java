package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "r_id")
	private String id;

	@Column(name = "r_name")
	private String name;

	@Column(name = "r_description")
	private String desc;
	
	
}
