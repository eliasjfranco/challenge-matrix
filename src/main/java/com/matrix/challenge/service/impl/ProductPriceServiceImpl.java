package com.matrix.challenge.service.impl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.matrix.challenge.dto.response.ProductPriceResponseDTO;
import com.matrix.challenge.exception.ParametersException;
import com.matrix.challenge.exception.ProductNotFoundException;
import com.matrix.challenge.model.ProductPrice;
import com.matrix.challenge.repository.ProductPriceRepository;
import com.matrix.challenge.service.ProductPriceService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductPriceServiceImpl implements ProductPriceService {

	@Autowired
	private ProductPriceRepository productPriceRepository;
	
	@Override
	public ProductPriceResponseDTO findProductPrice(LocalDateTime date, Integer productId, Integer brandId)
			throws Exception {
		validateParams(date, productId, brandId);
		
		List<ProductPrice> productPrice = productPriceRepository.findByPkProductIdAndPkGroupId(productId, brandId);
		log.info(productPrice.toString());
				
		ProductPrice product = productPrice.stream()
				.filter(item -> 
					item.getPriceList().getStartDate().isBefore(date) && item.getPriceList().getEndDate().isAfter(date))
				.sorted(Comparator.comparing(ProductPrice::getPriority).reversed())
				.limit(1)
				.findAny()
				.orElseThrow(() -> new ProductNotFoundException("Product not found in date: " + date + " for group: " + brandId));
		
		return ProductPriceResponseDTO.builder()
				.productId(product.getProduct().getProductPk().getId())
				.brandId(brandId)
				.priceListId(product.getPriceList().getPriceListPK().getId())
				.startDate(product.getPriceList().getStartDate())
				.endDate(product.getPriceList().getEndDate())
				.price(product.getPrice())
				.build();
	}

	private void validateParams(LocalDateTime date, Integer productId, Integer brandId) throws Exception {
		if (date == null)
			throw new ParametersException("Parameter date is required");
		if (productId == null)
			throw new ParametersException("Parameters productId is required");
		if (brandId == null)
			throw new ParametersException("Parameter brandId is required");
	}
}
