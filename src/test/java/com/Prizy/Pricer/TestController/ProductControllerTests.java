package com.Prizy.Pricer.TestController;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Prizy.Pricer.Controller.ProductController;
import com.Prizy.Pricer.Service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
class ProductControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	String data = "{\"barcode\":\"BC002\",	\"price\":113,	\"notes\":\"NotesServey\",	\"store\":\"Prizy\"}";

	@Test
	public void retrieveAllDetailsForCourse() throws Exception {

		Mockito.when(productService.getAllProducts()).thenReturn(data);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{barcode:BC002, price:113, notes:NotesServey,	store:Prizy}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	String data1 = "{success:true, msg: Successfullysaved}";

	@Test
	public void saveProductSurveyTest() throws Exception {
		String expected = "";
		JSONObject json = new JSONObject(data1);
		Mockito.when(productService.saveProductSurvey(json)).thenReturn(data1);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/productsurvey");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(expected, result.getResponse().getContentAsString());
	}

	@Test
	public void retrieveDetailsForBarcode() throws Exception {
		String expected = "{barcode:BC002, price:113, notes:NotesServey, store:Prizy}";

		Mockito.when(productService.getProductDetails(Mockito.anyString())).thenReturn(data);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/BC001").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
