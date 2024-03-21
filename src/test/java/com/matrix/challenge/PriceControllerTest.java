package com.matrix.challenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.matrix.challenge.controller.PriceController;
import com.matrix.challenge.service.ProductPriceService;
import com.matrix.challenge.service.impl.ProductPriceServiceImpl;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private PriceController priceController;
	
	@MockBean
	private ProductPriceServiceImpl productPriceServiceImpl;
	
	@Mock
	private ProductPriceService productPriceService;
	
	private final String URL = "/price";
	
	private final String productId = "35455";
	private final String brandId = "1";
	
	@Test
	@DisplayName("Prueba de parametros")
	public void findPrice() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get(URL)
				.param("date", "2020-06-14T10:00:00")
				.param("productId", this.productId)
				.param("brandId", this.brandId))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	
}
