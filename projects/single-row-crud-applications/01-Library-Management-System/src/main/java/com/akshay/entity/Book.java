package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Book class map with Book table
 * This class represent book in Library Book Management
 */
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	@Column(nullable = false)
	@NonNull
	private String title;
	
	@Column(nullable = false)
	@NonNull
	private String author;
	
	@Column(nullable = false)
	@NonNull
	private Double price;
	
	@Column(nullable = false)
	@NonNull
	private String publisher;
	
	@Column(nullable = false)
	private Boolean available;
}
