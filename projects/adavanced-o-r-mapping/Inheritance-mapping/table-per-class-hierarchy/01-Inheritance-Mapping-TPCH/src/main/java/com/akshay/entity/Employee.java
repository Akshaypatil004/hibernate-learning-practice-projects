package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@Entity
@DiscriminatorValue("Employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee extends Person {
	
	@Column(length = 50)
	private String designation;
	
	@Column
	private Double salary;
	
	@Column
	private Integer deptNo;
	
	public Employee(String pname,String company, String designation,
			Double salary, Integer deptNo) {
		super(pname, company);
		this.designation = designation;
		this.salary = salary;
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return super.toString() + "Employee [designation=" + designation + ", salary=" + salary + ", deptNo=" + deptNo + "]";
	}
}
