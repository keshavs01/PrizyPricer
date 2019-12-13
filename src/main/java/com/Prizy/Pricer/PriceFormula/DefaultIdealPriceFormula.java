package com.Prizy.Pricer.PriceFormula;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DefaultIdealPriceFormula implements PriceFormula {

	@Override
	public BigDecimal idealPrice(List<BigDecimal> price) {
		// TODO Auto-generated method stub
		BigDecimal idealPrice = BigDecimal.ZERO;
		BigDecimal percent = new BigDecimal(0.20); // Multiply by 20%
		
		if(price.size() > 4) {
			BigDecimal sum = BigDecimal.ZERO;
			Collections.sort(price);
			price.remove(price.size()-1);
			price.remove(price.size()-1);
			price.remove(0);
			price.remove(0);
			for(BigDecimal num:price) {
				sum = sum.add(num);
			}
			sum = sum.divide(new BigDecimal(price.size()));
			sum = sum.add(sum.multiply(percent));
			return sum.setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			return idealPrice;
		}
	}
	
	public BigDecimal averagePrice(List<BigDecimal> price) {
		BigDecimal sum = BigDecimal.ZERO;
		for(BigDecimal bd : price) {
			sum = sum.add(bd);
		}
		sum = sum.divide(new BigDecimal(price.size()));
		return sum.setScale(2, BigDecimal.ROUND_HALF_UP) ;
	}

}
