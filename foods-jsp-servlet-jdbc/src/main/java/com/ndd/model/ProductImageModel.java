package com.ndd.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductImageModel extends AbstractModel<ProductImageModel> {
	private String name;
	private String type;
	private byte[] data;
	private Long productId;
	
}
