// Employee.java
package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name="emp")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer empid;
	
	@NonNull
	@Column(length = 50)
	private String name;
	
	@NonNull
	@Column
	private Float salary;
	
	@NonNull
	@Column(length = 100)
	private String desg;
	

}
