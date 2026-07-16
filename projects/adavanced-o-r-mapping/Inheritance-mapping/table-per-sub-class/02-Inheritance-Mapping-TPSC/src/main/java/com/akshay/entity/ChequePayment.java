package com.akshay.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CHEQUEPAYMET_TPSC_DIS")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID", referencedColumnName = "txId")
@DiscriminatorValue("cheque")
@Getter
@Setter
@NoArgsConstructor
public class ChequePayment extends Payment {
	
	@Column
	private Integer chequeNo;
	
	@Column(length = 30)
	private String chequeType;

	public ChequePayment(Double amount, LocalDate txDate, Integer chequeNo, String chequeType) {
		super(amount, txDate);
		this.chequeNo = chequeNo;
		this.chequeType = chequeType;
	}

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + "]" + super.toString();
	}



	
}
