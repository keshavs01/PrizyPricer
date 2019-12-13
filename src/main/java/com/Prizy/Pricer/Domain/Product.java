package com.Prizy.Pricer.Domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Product {
	
	@Id
	@Column(name = "barcode")
	private String productBarcode;
	
	@Column(name = "name")
	private String productName;
	
	@Column(name = "description", nullable = false)
	private String productDesc;
	
	@Transient
	private BigDecimal avgPrice;
	
	@Transient
	private BigDecimal minPrice;
	
	@Transient
	private BigDecimal maxPrice;
	
	@Transient
	private BigDecimal idealPrice;
	
	@Transient
	private Integer noOfPrices;
	

	public Integer getNoOfPrices() {
		return noOfPrices;
	}

	public void setNoOfPrices(Integer noOfPrices) {
		this.noOfPrices = noOfPrices;
	}

	public String getProductBarcode() {
		return productBarcode;
	}

	public void setProductBarcode(String productBarcode) {
		this.productBarcode = productBarcode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public BigDecimal getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(BigDecimal avgPrice) {
		this.avgPrice = avgPrice;
	}

	public BigDecimal getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(BigDecimal minPrice) {
		this.minPrice = minPrice;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(BigDecimal maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BigDecimal getIdealPrice() {
		return idealPrice;
	}

	public void setIdealPrice(BigDecimal idealPrice) {
		this.idealPrice = idealPrice;
	}

	@Override
	public String toString() {
		return "Product [productBarcode=" + productBarcode + ", productName=" + productName + ", productDesc="
				+ productDesc + ", avgPrice=" + avgPrice + ", minPrice=" + minPrice
				+ ", maxPrice=" + maxPrice + ", idealPrice=" + idealPrice + ", noOfPrices=" + noOfPrices + "]";
	}
	
	public String toProdString() {
		return "Product [productBarcode=" + productBarcode + ", productName=" + productName + ", productDesc="
				+ productDesc + "]";
	}
}
