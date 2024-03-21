package com.matrix.challenge;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.matrix.challenge.exception.ProductNotFoundException;
import com.matrix.challenge.model.ProductPrice;
import com.matrix.challenge.repository.ProductPriceRepository;
import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@Slf4j
public class PriceJpaTest {

	@Autowired
	private ProductPriceRepository productPriceRepository;
	
	private LocalDateTime date = null;
	private final Integer productId = 35455;
	private final Integer brandId = 1;
	
	@Test
	@DisplayName("Test 1")
	void testByParams1() throws Exception {
		this.date = LocalDateTime.of(2020,  06, 14, 10, 00, 00);
		unexpectedError(new BigDecimal(35.50));
	}
	

	
	@Test
	@DisplayName("Test 2")
	void testByParams2() throws Exception {
		this.date = LocalDateTime.of(2020, 06, 14, 16, 00, 00);
		unexpectedError(new BigDecimal(25.45));
	}
	
	@Test
	@DisplayName("Test 3")
	void testByParams3() throws Exception{
		this.date = LocalDateTime.of(2020, 06, 14, 21, 00, 00);
		unexpectedError(new BigDecimal(35.50));
	}
	
	@Test
	@DisplayName("Test 4")
	void testByParams4() throws Exception {
		this.date = LocalDateTime.of(2020, 06, 15, 10, 00, 00);
		unexpectedError(new BigDecimal(30.50));
	}
	
	@Test
	@DisplayName("Test 5")
	void testByParams5() {
		this.date = LocalDateTime.of(2020, 06, 16, 21, 00, 00);
		unexpectedError(new BigDecimal(38.95));
	}
	
	@Test
	@DisplayName("Test 6")
	void testByParams6() {
		this.date = LocalDateTime.of(2019, 06, 16, 21, 00, 00);
		expectedErrorProductNotFound(new BigDecimal(38.95));
	}
	
	void expectedErrorProductNotFound(BigDecimal price) {
		List<ProductPrice> productPrice = this.findProductPrice();
		assertThrows(ProductNotFoundException.class, () -> getProductPrice(productPrice), "Se esperaba excepcion");
	}
	
	void unexpectedError(BigDecimal price) {
		List<ProductPrice> productPrice = this.findProductPrice();
		assertDoesNotThrow(() -> getProductPrice(productPrice), "No se esperaba excepcion");
		try {
			ProductPrice product = getProductPrice(productPrice);
			assertEquals(price.setScale(2), product.getPrice());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	
	private List<ProductPrice> findProductPrice() {
		return productPriceRepository.findByPkProductIdAndPkGroupId(this.productId, this.brandId);
	}
	
	private ProductPrice getProductPrice(List<ProductPrice> productPrice) throws Exception {
		return productPrice.stream()
				.filter(item -> item.getPriceList().getStartDate().isBefore(this.date) && item.getPriceList().getEndDate().isAfter(this.date))
				.sorted(Comparator.comparing(ProductPrice::getPriority).reversed())
				.limit(1)
				.findAny()
				.orElseThrow(() -> new ProductNotFoundException("Product not found in date: " + this.date + " for group: " + this.brandId));
	}
}
