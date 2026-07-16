package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PERSON_TPCH")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // FOR Inheritance mapping with table per class hierarchy strategy
@Inheritance // here default strategy is InheritanceType.SINGLE_TABLE 
@DiscriminatorColumn(name="PERSON_TYPE",length = 30,discriminatorType = DiscriminatorType.STRING)  
@DiscriminatorValue("Person")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
