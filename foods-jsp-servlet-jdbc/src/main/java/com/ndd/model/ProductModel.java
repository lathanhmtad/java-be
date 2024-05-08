package com.ndd.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ProductModel extends AbstractModel<ProductModel> {
	private String name;
	private String trademark;
	private String amount;
	private Double price;
	private Double disount;
	private String origin;
	private String mass;
	private String description;
	
}
