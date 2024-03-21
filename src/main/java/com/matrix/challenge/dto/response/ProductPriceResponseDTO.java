package com.matrix.challenge.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPriceResponseDTO {

	private Integer productId;
	private Integer brandId;
	private Integer priceListId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
	
}
