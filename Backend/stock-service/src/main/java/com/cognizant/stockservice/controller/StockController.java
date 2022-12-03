package com.cognizant.stockservice.controller;

import com.cognizant.stockservice.entity.Stock;
import com.cognizant.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addStock(@RequestBody Stock stock){
        String successMessage = stockService.addStock(stock);

        ResponseEntity<String> response = new ResponseEntity<>(successMessage, HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "/{companyId}")
    public ResponseEntity<List<Stock>> getStockPriceList(@PathVariable Long companyId){
        List<Stock> stocksFromCompany = stockService.getStockPriceList(companyId);

        ResponseEntity<List<Stock>> respone = new ResponseEntity<>(stocksFromCompany, HttpStatus.OK);
        return respone;
    }

}
