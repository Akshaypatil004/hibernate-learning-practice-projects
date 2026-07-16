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
@Table(name = "PERSON_CUSTOMER_TPSC_DIS")
@PrimaryKeyJoinColumn(name="PERSON_PID", referencedColumnName = "pid")
@DiscriminatorValue("Customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer extends Person{
	@Column
	private Double billAmount;
	
	@Column
	private Integer billNo;

	public Customer(String pname, String company, Double billAmount, Integer billNo) {
		super(pname, company);
		this.billAmount = billAmount;
		this.billNo = billNo;
	}

	@Override
	public String toString() {
		return "Customer [billAmount=" + billAmount + ", billNo=" + billNo + "]" + super.toString();
	}
}
