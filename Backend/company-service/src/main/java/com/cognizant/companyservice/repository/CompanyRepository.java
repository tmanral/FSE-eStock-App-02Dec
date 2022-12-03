package com.cognizant.companyservice.repository;

import com.cognizant.companyservice.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

/*
    1. JpaRepository extends PagingAndSortingRepository. It provides all the methods for implementing the pagination.

    2. JpaRepository extends both CrudRepository and PagingAndSortingRepository.

    3. It provides some extra methods along with the method of PagingAndSortingRepository and CrudRepository.
        For example, flush(), deleteInBatch().

    4. It is used when we want to implement pagination and sorting functionality in an application.
*/


}
