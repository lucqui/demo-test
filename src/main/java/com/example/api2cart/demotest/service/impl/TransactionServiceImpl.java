package com.example.api2cart.demotest.service.impl;

import com.example.api2cart.demotest.dao.TransactionRepository;
import com.example.api2cart.demotest.model.Transaction;
import com.example.api2cart.demotest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAll() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    @Override
    public Transaction get(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public void add(Transaction entity) {
        transactionRepository.save(entity);
    }

    @Override
    public void delete(Transaction entity) {
        transactionRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        transactionRepository.deleteById(entityId);
    }

    @Override
    public void update(Transaction entity) {
        transactionRepository.save(entity);
    }
}