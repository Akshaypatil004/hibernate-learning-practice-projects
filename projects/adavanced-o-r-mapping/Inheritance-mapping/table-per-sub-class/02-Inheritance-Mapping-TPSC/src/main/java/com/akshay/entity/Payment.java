package com.akshay.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
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
@Table(name="PAYMENT_TPSC_DIS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="PAYMENT_TYPE",discriminatorType = DiscriminatorType.STRING,length = 50)
@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer txId;
	
	@Column
	private Double amount;
	
	@Column
	private LocalDate txDate;

	protected Payment(Double amount, LocalDate txDate) {
		this.amount = amount;
		this.txDate = txDate;
	}
}
