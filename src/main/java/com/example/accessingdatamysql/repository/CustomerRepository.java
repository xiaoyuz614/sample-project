package com.example.accessingdatamysql.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.model.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    void findAllByCustomerId(int id);
   @Query("SELECT c FROM Customer c WHERE c.zipcode in :zipcodes")
   List<Customer> findCustomerByZipcode(@Param("zipcodes") List<String> zipcodes);


}