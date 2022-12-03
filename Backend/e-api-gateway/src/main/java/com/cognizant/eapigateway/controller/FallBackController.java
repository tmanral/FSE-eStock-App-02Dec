package com.cognizant.eapigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/companyServiceFallBack")
    public String companyServiceFallBackMethod(){
        return "Company Service is taking more time than expected to respond. Please try again later.";
    }

    @GetMapping("/stockServiceFallBack")
    public String stockServiceFallBackMethod(){
        return "Stock Service is taking more time than expected to respond. Please try again later.";
    }

}
