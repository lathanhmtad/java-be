package model;

import java.sql.Timestamp;

import lombok.Data;

@Data

public class AbstractModel<T> {
	private Long id;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String createdBy;
	private String modifiedBy;
}
