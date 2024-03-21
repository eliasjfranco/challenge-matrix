package com.matrix.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.matrix.challenge.model.PriceList;
import com.matrix.challenge.model.PriceListPK;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, PriceListPK>{

}
