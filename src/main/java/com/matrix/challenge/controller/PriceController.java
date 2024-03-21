package com.matrix.challenge.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.matrix.challenge.service.ProductPriceService;
import com.matrix.challenge.util.DateUtils;


@RestController
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
	private ProductPriceService productPriceService;
	
	@GetMapping()
	ResponseEntity<?> findPrice(@RequestParam(value = "date", required = false) @DateTimeFormat(pattern = DateUtils.ISO_DATETIME_PATTERN_CONTROLLERS) LocalDateTime date,
								@RequestParam(value = "productId", required = false) Integer productId,
								@RequestParam(value = "brandId", required = false) Integer brandId) throws Exception {
		return ResponseEntity.ok(productPriceService.findProductPrice(date, productId, brandId));
	}

}
