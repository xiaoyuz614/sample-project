package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Transaction;
import com.example.accessingdatamysql.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/transaction")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;


    @GetMapping(path = "/between-dates")
    public @ResponseBody
    Iterable<Transaction> getTransactionBetweenDates(@RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date start = formatter.parse(startDate);
        Date end = formatter.parse(endDate);
        return transactionRepository.findAllTransactionBetweenDates(start, end);
    }

}
