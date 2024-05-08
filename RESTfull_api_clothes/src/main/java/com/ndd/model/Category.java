package com.ndd.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Category extends AbstractModel<Category> {
	private String name;	
}
