package com.cognizant.stockservice.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "stock")
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private String stockId;
    private Double stockPrice;
    private LocalDateTime stockAddTime;
    private Long companyCode;


    //getters & setters


    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public LocalDateTime getStockAddTime() {
        return stockAddTime;
    }

    public void setStockAddTime(LocalDateTime stockAddTime) {
        this.stockAddTime = stockAddTime;
    }

    public Long getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Long companyCode) {
        this.companyCode = companyCode;
    }
}
