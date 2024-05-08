package com.ndd.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Product extends AbstractModel<Product> {
	private String name;
	private String description;
	private double price;
	private byte[] thumbnail;
	private Category category;
}
