package com.cognizant.stockservice.repository;

import com.cognizant.stockservice.entity.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {


    @Query("{'companyCode': ?0}")
    List<Stock> getStocksByCompany(Long companyCode);

}
