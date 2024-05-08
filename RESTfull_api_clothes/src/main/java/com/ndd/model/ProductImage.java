package com.ndd.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductImage extends AbstractModel<ProductImage> {
	private String name;
	private String type;
	private byte[] imageData;
	private Product product;
}
