package com.matrix.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.matrix.challenge.model.ProductPrice;
import com.matrix.challenge.model.ProductPricePK;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPricePK>{

	List<ProductPrice> findByPkProductIdAndPkGroupId(Integer productId, Integer groupId);
}
