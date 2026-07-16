package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PERSON_EMPLOYEE_TPSC_DIS")
@PrimaryKeyJoinColumn(name = "PERSON_PID", referencedColumnName = "pid")
@DiscriminatorValue("Employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee extends Person{
	
	@Column(length = 50)
	private String designation;
	
	@Column
	private Double salary;
	
	@Column
	private Integer deptNo;

	public Employee(String pname, String company, String designation, Double salary, Integer deptNo) {
		super(pname, company);
		this.designation = designation;
		this.salary = salary;
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employee [designation=" + designation + ", salary=" + salary + ", deptNo=" + deptNo + "]" + super.toString();
	}
}
