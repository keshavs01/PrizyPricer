package com.Prizy.Pricer.Controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Prizy.Pricer.Service.ProductService;
import com.Prizy.Pricer.util.Constants;
import com.Prizy.Pricer.util.StringUtil;

@RestController
public class ProductController {
	
	Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productServiceObj;
	
	@GetMapping("/product/{barcode}")
	public String getProductByBarcode(@PathVariable String barcode) throws JSONException {
		try {
			if(!StringUtil.isNullOrEmpty(barcode)) {
				return productServiceObj.getProductDetails(barcode);
			} else {
				return Constants.Message.INVALID_BARCODE;
			}			
		} catch(Exception e) {
			return e.getMessage();
		}
		
	}
	
	@GetMapping("/product")
	public String getAllProduct() throws JSONException {
		try {
			return productServiceObj.getAllProducts();
		} catch(Exception e) {
			return e.getMessage();
		}
	}
	
	
	@PostMapping("/productservey")
	public String saveProduct(@RequestParam(Constants.DATA) JSONObject paramJobj) throws JSONException {
		try {
			return productServiceObj.saveProductSurvey(paramJobj);
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}

}
