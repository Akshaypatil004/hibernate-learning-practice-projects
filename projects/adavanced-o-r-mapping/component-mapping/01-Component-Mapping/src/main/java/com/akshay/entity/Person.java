package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class represent PERSON_DETAILS table in db (map entity class)
 * contain person's information 
 * showcase's component mapping(composition/HAS-A property in it)
 */
@Entity
@Table(name="PERSON_DETAILS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@Column(length = 50)
	@NonNull
	private String name;
	
	@Column(length = 100)
	@NonNull
	private String address;
	
	// this is component mapping / HAS-A property 
	@Embedded
	@NonNull
	private JobDetails job;
}
