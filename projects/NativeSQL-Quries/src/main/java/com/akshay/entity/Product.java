// Product.java
package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NamedNativeQuery(name="GET_ALL_PRODUCTS",
				  query="SELECT * FROM PRODUCT",
				  resultClass = Product.class)
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
