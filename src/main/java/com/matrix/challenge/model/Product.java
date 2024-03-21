package com.matrix.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@EmbeddedId
	private ProductPK productPk;
	
	@OneToOne
	@JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID", insertable = false, updatable = false)
	private Group group;
	
	@Column(name = "PRODUCT_NAME")
	private String name;
	
	

	
}
