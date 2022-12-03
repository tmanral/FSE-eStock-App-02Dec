package com.cognizant.companyservice.controller;

import com.cognizant.companyservice.VO.ResponseTemplateVO;
import com.cognizant.companyservice.entity.Company;
import com.cognizant.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService service;


    @PostMapping(value = "/add")
    public ResponseEntity<String> addcompany(@RequestBody Company company){
        service.addCompany(company);
        String successMessage = "company with Id " + company.getCompanyCode() + " added successfully.";
        ResponseEntity<String> response = new ResponseEntity<>(successMessage, HttpStatus.CREATED);
        return response;
    }

    @GetMapping(value = "/{companyId}")
    public ResponseEntity<Company> getCompanyDetails(@PathVariable Long companyId){
        Company company = service.getCompanyByCode(companyId);

        if(company.getCompanyCode() != -1L){
            ResponseEntity<Company> response = new ResponseEntity<>(company, HttpStatus.OK);
            return response;
        }
        else{
            ResponseEntity<Company> response = new ResponseEntity<>(company, HttpStatus.BAD_REQUEST);
            return response;
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Company>> getAllCompanies(){
        List<Company> companiesList = service.getAllCompanies();
        ResponseEntity<List<Company>> response = new ResponseEntity<>(companiesList, HttpStatus.OK);
        return response;
    }

    @DeleteMapping(value = "/delete/{companyCode}")
    public ResponseEntity<String> deleteCompanyByCode(@PathVariable Long companyCode){
        String serviceMessage = service.deleteCompanyByCode(companyCode);
        ResponseEntity<String> response = new ResponseEntity<>(serviceMessage, HttpStatus.OK);
        return response;
    }


    //To return company details along with all the stocks
    @GetMapping(value = "/{companyId}/details")
    public ResponseEntity<ResponseTemplateVO> getCompanyWithStocks(@PathVariable Long companyId){

        ResponseTemplateVO vo = service.getStocksWithCompany(companyId);
        ResponseEntity<ResponseTemplateVO> response = new ResponseEntity<>(vo, HttpStatus.OK);
        return response;
    }
}
