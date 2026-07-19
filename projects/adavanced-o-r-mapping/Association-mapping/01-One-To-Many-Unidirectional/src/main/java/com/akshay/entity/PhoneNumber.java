package com.akshay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PHONENUMBER_OTM_UNIDIRECTIONAL")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class PhoneNumber {

	@Id
	@GeneratedValue
	private Integer registrationNo;

	@Column(nullable = false)
	@NonNull
	private Long mobileNumber;

	@Column(length = 50, nullable = false)
	@NonNull
	private String numberType;

	@Column(length = 50, nullable = false)
	@NonNull
	private String provider;
}
