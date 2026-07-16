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
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="PERSON_TPSC_DIS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PERSON_TYPE",discriminatorType = DiscriminatorType.STRING,length = 50)
@DiscriminatorValue("Person")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@Column(length = 50)
	private String pname;
	
	@Column(length = 50)
	private String company;

	public Person(String pname, String company) {
		this.pname = pname;
		this.company = company;
	}
}
