package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class RoleModel extends AbstractModel<RoleModel>{
	private String name;
	private String code;
}
