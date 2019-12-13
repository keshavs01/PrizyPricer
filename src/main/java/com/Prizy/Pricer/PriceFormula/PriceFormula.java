package com.Prizy.Pricer.PriceFormula;

import java.math.BigDecimal;
import java.util.List;

public interface PriceFormula {
	
	public BigDecimal idealPrice(List<BigDecimal> price);
	
	public BigDecimal averagePrice(List<BigDecimal> price);
	
	

}
