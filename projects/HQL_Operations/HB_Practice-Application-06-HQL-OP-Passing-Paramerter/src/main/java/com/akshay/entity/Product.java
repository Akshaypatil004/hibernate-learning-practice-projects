// Product.java
package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@Column
	@NonNull
	private String pname;
	
	@Column
	@NonNull
	private Float price;
	
	@Column
	@NonNull
	private Integer qty;
	
	public Product() {
		System.out.println("Product.Product() :: constructor invoked");
	}

}
