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
@Table(name="CARDPAYMET_TPSC_DIS")
@PrimaryKeyJoinColumn(name = "PAYMENT_ID", referencedColumnName = "txId")
@DiscriminatorValue("card")
@Getter
@Setter
@NoArgsConstructor
public class CardPayment extends Payment {
	
	@Column
	private Integer cardNo;
	
	@Column(length = 50)
	private String cardType;
	
	@Column(length = 50)
	private String gateway;

	public CardPayment(Double amount, LocalDate txDate, Integer cardNo, String cardType, String gateway) {
		super(amount, txDate);
		this.cardNo = cardNo;
		this.cardType = cardType;
		this.gateway = gateway;
	}

	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", gateway=" + gateway + "]" + super.toString();
	}



	
}
