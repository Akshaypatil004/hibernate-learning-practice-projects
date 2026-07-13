package com.akshay.dto;

/**
 * This class(record) represent result of book price changes
 */
public record BookPriceUpdateResult(Integer bookId,Double oldPrice, Double newPrice) {}

