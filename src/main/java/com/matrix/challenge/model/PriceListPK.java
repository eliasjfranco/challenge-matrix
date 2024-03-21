package com.matrix.challenge.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Embeddable
@Data
public class PriceListPK implements Serializable {

	private static final long serialVersionUID = 1L;


	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRICE_LIST")
	private Integer id;
	
	@Column(name = "BRAND_ID")
	private Integer groupId;
	

}
