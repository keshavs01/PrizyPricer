package com.Prizy.Pricer.PriceFormula;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class TestDefaultIdealFormula {
	
	@Test
	void testDefaultIdealPrice() {
		List<BigDecimal> priceList = new ArrayList<>();
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        
        PriceFormula pf = new DefaultIdealPriceFormula();
        BigDecimal numb = pf.idealPrice(priceList);
        numb.setScale(2, BigDecimal.ROUND_HALF_UP);        
        assertThat(new BigDecimal(3.60).setScale(2, BigDecimal.ROUND_HALF_UP), is(equalTo(numb)));
        
	}
	
	@Test
	void testAveragePrice() {
		List<BigDecimal> priceList = new ArrayList<>();
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        priceList.add(new BigDecimal(3.0));
        
        PriceFormula pf = new DefaultIdealPriceFormula();
        BigDecimal numb = pf.averagePrice(priceList);
        numb.setScale(2, BigDecimal.ROUND_HALF_UP);        
        assertThat(new BigDecimal(3.0).setScale(2, BigDecimal.ROUND_HALF_UP), is(equalTo(numb)));
        
	}

}
