package com.matrix.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.matrix.challenge.model.Product;
import com.matrix.challenge.model.ProductPK;

@Repository
public interface ProductRepository extends JpaRepository<Product, ProductPK>{

}
