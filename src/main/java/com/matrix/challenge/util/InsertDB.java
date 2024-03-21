/*package com.matrix.challenge.util;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.matrix.challenge.model.Group;
import com.matrix.challenge.model.PriceList;
import com.matrix.challenge.model.PriceListPK;
import com.matrix.challenge.model.Product;
import com.matrix.challenge.model.ProductPK;
import com.matrix.challenge.model.ProductPrice;
import com.matrix.challenge.model.ProductPricePK;
import com.matrix.challenge.repository.GroupRepository;
import com.matrix.challenge.repository.PriceListRepository;
import com.matrix.challenge.repository.ProductPriceRepository;
import com.matrix.challenge.repository.ProductRepository;

@Component
public class InsertDB implements CommandLineRunner {

	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private PriceListRepository priceListRepository;
	@Autowired
	private ProductPriceRepository productPriceRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Group group = saveGroup();
		
		saveProduct(group);
		savePriceList(group);
		saveProductPrice(group);
		
	}
	
	private Group saveGroup() {
		Group group = new Group();
		group.setName("ZARA");
		return groupRepository.save(group);
	}
	
	private void saveProduct(Group group) {
		Product product = new Product();
		ProductPK productPK = new ProductPK();
		productPK.setGroupId(group.getId());
		productPK.setId(35455);
		product.setProductPk(productPK);
		product.setName("Galletita");
		productRepository.save(product);
	}
	
	private void savePriceList(Group group) {
		List<PriceList> list = new ArrayList<PriceList>();
		PriceList priceList = new PriceList();
		PriceListPK pk = new PriceListPK();
		pk.setGroupId(group.getId());
		priceList.setStartDate(LocalDateTime.of(2020, 06, 14, 00, 00, 00));
		priceList.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		priceList.setPriority(0);
		priceList.setPriceListPK(pk);
		
		list.add(priceList);
		
		priceList = new PriceList();
		priceList.setStartDate(LocalDateTime.of(2020, 06, 14, 15, 00, 00));
		priceList.setEndDate(LocalDateTime.of(2020, 06, 14, 18, 30, 00));
		priceList.setGroup(group);
		priceList.setPriority(1);
		priceList.setPriceListPK(pk);
		
		list.add(priceList);
		
		priceList = new PriceList();
		priceList.setStartDate(LocalDateTime.of(2020, 06, 15, 00, 00, 00));
		priceList.setEndDate(LocalDateTime.of(2020, 06, 15, 11, 00, 00));
		priceList.setGroup(group);
		priceList.setPriority(1);
		priceList.setPriceListPK(pk);
		
		list.add(priceList);
		
		priceList = new PriceList();
		priceList.setStartDate(LocalDateTime.of(2020, 06, 15, 16, 00, 00));
		priceList.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		priceList.setGroup(group);
		priceList.setPriority(1);
		priceList.setPriceListPK(pk);
		
		list.add(priceList);
		
		priceListRepository.saveAll(list);
		
	}
	
	private void saveProductPrice(Group group) {
		List<ProductPrice> list = new ArrayList<ProductPrice>();
		ProductPrice productPrice = new ProductPrice();
		
		ProductPricePK pk = new ProductPricePK();
		pk.setPriceListId(1);
		pk.setProductId(35455);
		pk.setGroupId(1);
		
		productPrice.setCurrency("EUR");
		productPrice.setPrice(new BigDecimal(35.50));
		productPrice.setPk(pk);
		
		list.add(productPrice);
		
		pk = new ProductPricePK();
		pk.setPriceListId(2);
		pk.setProductId(35455);
		pk.setGroupId(1);
		
		productPrice = new ProductPrice();
		productPrice.setCurrency("EUR");
		productPrice.setPrice(new BigDecimal(24.45));
		productPrice.setPk(pk);
		
		list.add(productPrice);
		
		pk = new ProductPricePK();
		pk.setPriceListId(3);
		pk.setProductId(35455);
		pk.setGroupId(1);
		
		productPrice = new ProductPrice();
		productPrice.setCurrency("EUR");
		productPrice.setPrice(new BigDecimal(30.50));
		productPrice.setPk(pk);
		
		list.add(productPrice);
		
		pk = new ProductPricePK();
		pk.setPriceListId(4);
		pk.setProductId(35455);
		pk.setGroupId(1);
		
		productPrice = new ProductPrice();
		productPrice.setCurrency("EUR");
		productPrice.setPrice(new BigDecimal(38.95));
		productPrice.setPk(pk);
		
		list.add(productPrice);
		
		productPriceRepository.saveAll(list);
		
	}
}*/
