package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CUSTOMER_TPCC")
@NoArgsConstructor
@Getter
@Setter
public class Customer extends Person{
	@Column
	private Double billAmount;
	
	@Column
	private Integer billNo;
	
	public Customer(String pname, String company, Double billAmount,
			Integer billNo) {
		super(pname, company);
		this.billAmount = billAmount;
		this.billNo = billNo;
	}

	@Override
	public String toString() {
		return super.toString() + "Customer [billAmount=" + billAmount + ", billNo=" + billNo + "]";
	}




}
