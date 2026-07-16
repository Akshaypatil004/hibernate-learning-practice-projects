package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PERSON_TPCC")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	
	@Column(length = 40)
	private String pname;
	
	@Column(length = 50)
	private String company;

	public Person(String pname, String company) {
		this.pname = pname;
		this.company = company;
	}
	
	
}
