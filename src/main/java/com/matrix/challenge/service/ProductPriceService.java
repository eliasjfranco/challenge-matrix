package com.matrix.challenge.service;

import java.time.LocalDateTime;
import com.matrix.challenge.dto.response.ProductPriceResponseDTO;

public interface ProductPriceService {
	
	ProductPriceResponseDTO findProductPrice(LocalDateTime date, Integer productId, Integer brandId) throws Exception;

}
