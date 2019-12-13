package com.Prizy.Pricer.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prizy.Pricer.Domain.Product;
import com.Prizy.Pricer.Domain.ProductSurvey;
import com.Prizy.Pricer.PriceFormula.DefaultIdealPriceFormula;
import com.Prizy.Pricer.Repository.ProductRepository;
import com.Prizy.Pricer.util.Constants;
import com.Prizy.Pricer.util.StringUtil;

@Service
public class ProductService {

	@Autowired
	DefaultIdealPriceFormula priceFormula;

	@Autowired
	ProductRepository prodRepo;

	public String saveProductSurvey(JSONObject paramJobj) throws ServiceException {
		try {
			String barcode;
			Product product = null;
			ProductSurvey productSurvey = new ProductSurvey();

			if (!StringUtil.isNullOrEmpty(paramJobj.optString(Constants.PRODUCT_BARCODE, ""))) {
				barcode = paramJobj.optString(Constants.PRODUCT_BARCODE, "");
				List<Product> prod = prodRepo.getProductByBarcode(barcode);
				if (prod.isEmpty()) {
					throw new ServiceException(Constants.Message.INVALID_BARCODE);
				} else {
					product = prod.get(0);
				}
				productSurvey.setProduct(product);
			} else {
				throw new ServiceException(Constants.Message.INVALID_BARCODE);
			}

			if (paramJobj.optBigDecimal(Constants.PRICE, BigDecimal.ZERO) != BigDecimal.ZERO) {
				productSurvey.setPrice(paramJobj.getBigDecimal(Constants.PRICE));
			}
			if (!StringUtil.isNullOrEmpty(paramJobj.optString(Constants.NOTES))) {
				productSurvey.setNotes(paramJobj.getString(Constants.NOTES));
			}
			if (!StringUtil.isNullOrEmpty(paramJobj.optString(Constants.STORE_NAME))) {
				productSurvey.setStoreName(paramJobj.getString(Constants.STORE_NAME));
			}
			prodRepo.saveProductServey(productSurvey);
			return "{success:true, msg: Successfully saved}";
		} catch (Exception e) {
			throw new ServiceException(Constants.Message.ERROR_IN_SAVE);
		}

	}

	public String getProductDetails(String productBarcode) throws JSONException {
		JSONArray jarray = new JSONArray();
		List<Product> prod = prodRepo.getProductByBarcode(productBarcode);
		List<ProductSurvey> prodSurvey = prodRepo.getProductSurveyData(productBarcode);
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();

		if (!prodSurvey.isEmpty()) {
			for (ProductSurvey ps : prodSurvey) {
				priceList.add(ps.getPrice());
			}
		}

		Collections.sort(priceList);

		if (!prod.isEmpty()) {
			JSONObject jobj = new JSONObject();
			for (Product p : prod) {
				jobj.put(Constants.PRODUCT_NAME, p.getProductName());
				jobj.put(Constants.DESCRIPTION, p.getProductDesc());
				jobj.put(Constants.PRODUCT_BARCODE, p.getProductBarcode());
				if (priceList.size() > 0) {
					jobj.put(Constants.MAX_PRICE, priceList.get(priceList.size() - 1));
					jobj.put(Constants.MIN_PRICE, priceList.get(0));
					jobj.put(Constants.NO_OF_ITEMS, priceList.size());
					jobj.put(Constants.IDEAL_PRICE, priceFormula.idealPrice(priceList));
					jobj.put(Constants.AVG_PRICE, priceFormula.averagePrice(priceList));
				}
				jarray.put(jobj);
				jobj = new JSONObject();
			}
		} else {
			return Constants.Message.INVALID_BARCODE;
		}
		return jarray.toString(5);
	}

	public String getAllProducts() throws JSONException {
		Product pdata = new Product();
		List<Product> prod = prodRepo.getAllProducts();
		JSONArray jarray = new JSONArray();
		if (!prod.isEmpty()) {
			JSONObject jobj = new JSONObject();
			for (Product p : prod) {
				jobj.put(Constants.PRODUCT_NAME, p.getProductName());
				jobj.put(Constants.DESCRIPTION, p.getProductDesc());
				jobj.put(Constants.PRODUCT_BARCODE, p.getProductBarcode());
				jarray.put(jobj);
				jobj = new JSONObject();
			}
		} else {
			return Constants.Message.NO_RECORDS;
		}
		return jarray.toString(5);
	}

}
