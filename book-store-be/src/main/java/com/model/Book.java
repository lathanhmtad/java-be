package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String author;
	private double price;
	private String languages;
	private int length;
	private String description;
	
	@OneToMany(mappedBy = "book")
	private List<BookImage> images;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}
