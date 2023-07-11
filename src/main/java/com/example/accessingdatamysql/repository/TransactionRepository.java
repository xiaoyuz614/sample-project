package com.example.accessingdatamysql.repository;

import com.example.accessingdatamysql.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    @Query("SELECT t FROM Transaction t WHERE t.date > :startDate and t.date < :endDate")
    List<Transaction> findAllTransactionBetweenDates(Date startDate, Date endDate);

    @Query("SELECT t FROM Transaction t WHERE t.customerId = :customerId")
    List<Transaction> findAllTransactionForCustomer(int customerId);
}
