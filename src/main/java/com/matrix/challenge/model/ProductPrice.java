package com.matrix.challenge.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT_PRICE")
public class ProductPrice {
	
	@EmbeddedId
	private ProductPricePK pk;
	
	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "CURRENCY")
	private String currency;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PRICE_LIST", referencedColumnName = "PRICE_LIST", insertable = false, updatable = false),
		@JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID", insertable = false, updatable = false)
	})
	private PriceList priceList;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", insertable = false, updatable = false),
		@JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID", insertable = false, updatable = false)
	})
	private Product product;
	
	public Integer getPriority() {
		return this.priceList.getPriority();
	}
}
