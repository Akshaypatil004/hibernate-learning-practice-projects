package com.akshay.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represent result of book price changes
 */
@NoArgsConstructor
@Getter
@Setter
public class BookPriceUpdateResult {
	private Integer bookId;
	private Double oldPrice;
	private Double newPrice;
}
