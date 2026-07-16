package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class contain job details
 * and map with PERSON_DETAILS table in db
 * this is helper class / dependent class to Person class
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class JobDetails {
	@Column(length = 50)
	private String desg;
	
	@Column(length = 50)
	private String company;
	
	@Column
	private Double salary;
}
