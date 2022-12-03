package com.cognizant.companyservice.service;

import com.cognizant.companyservice.VO.ResponseTemplateVO;
import com.cognizant.companyservice.VO.Stock;
import com.cognizant.companyservice.entity.Company;
import com.cognizant.companyservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private RestTemplate rT;

    public Company addCompany(Company company){
        return repository.save(company);
    }

    public Company getCompanyByCode(Long companyCode){
        Optional<Company> companyOptional = repository.findById(companyCode);

        if(companyOptional.isPresent()){
            return companyOptional.get();
        }
        else{
            Company nullCompany = new Company();
            nullCompany.setCompanyCode(-1L);
            return nullCompany;
        }
    }

    public List<Company> getAllCompanies(){
        return repository.findAll();
    }

    public String deleteCompanyByCode(Long companyCode){
        Company checkCompany = this.getCompanyByCode(companyCode);

        if(checkCompany.getCompanyCode() != -1L){
            repository.deleteById(companyCode);
            return "Company with code " + companyCode + " is successfully deleted.";
        }
        else{
            return "Company with code " + companyCode + " does not exist.";
        }

    }

    //To return response template for stocks details of company
    public ResponseTemplateVO getStocksWithCompany(Long companyId){

        Company company = this.getCompanyByCode(companyId);

        Stock[] msResponse =
                rT.getForObject("http://STOCK-SERVICE/stock/" + company.getCompanyCode(), Stock[].class);

        List<Stock> allStocks = new ArrayList<>();
        for(Stock ele : msResponse){
            allStocks.add(ele);
        }

        //adding company and stock details to the VO template
        ResponseTemplateVO vo = new ResponseTemplateVO();
        vo.setCompany(company);
        vo.setStocks(allStocks);
        return vo;

    }
}
