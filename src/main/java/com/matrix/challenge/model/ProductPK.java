package com.matrix.challenge.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ProductPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PRODUCT_ID")
	private Integer id;
	
	@Column(name = "BRAND_ID")
	private Integer groupId;
}
