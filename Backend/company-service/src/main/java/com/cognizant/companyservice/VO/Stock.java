package com.cognizant.companyservice.VO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    private String stockId;
    private Double stockPrice;
    private LocalDateTime stockAddTime;
    private Long companyCode;

    //getters and setters


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
