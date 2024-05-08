package com.ndd.model;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class AbstractModel<T> {
	private Long id;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String modifiedBy;
	private String createdBy;

}
