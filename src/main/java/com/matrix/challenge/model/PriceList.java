package com.matrix.challenge.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PRICE_LIST")
public class PriceList {
	
	@EmbeddedId
	private PriceListPK priceListPK;
	
	@OneToOne
	@JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID", insertable = false, updatable = false)
	private Group group;
	
	@Column(name = "START_DATE")
	private LocalDateTime startDate;
	
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	
	@Column(name = "PRIORITY")
	private Integer priority;
}
