package com.cognizant.stockservice.service;

import com.cognizant.stockservice.entity.Stock;
import com.cognizant.stockservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    public String addStock(Stock stock){

        LocalDateTime timeNow = LocalDateTime.now();
        stock.setStockAddTime(timeNow);
        repository.save(stock);
        return "stock price for " + stock.getCompanyCode() + " is added successfully " + "@" + stock.getStockAddTime();
    }

    public List<Stock> getStockPriceList(Long companyCode){
        List<Stock> stocks = repository.getStocksByCompany(companyCode);
        return stocks;
    }
}
