package com.example.api2cart.demotest.service.impl;

import com.example.api2cart.demotest.dao.TransactionRepository;
import com.example.api2cart.demotest.dto.TransactionDTO;
import com.example.api2cart.demotest.dto.mapper.TransactionMapper;
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
    public List<TransactionDTO> getAll() {
        return TransactionMapper.mapper.toDto((List<Transaction>) transactionRepository.findAll());
    }

    @Override
    public TransactionDTO get(Long id) {
        return TransactionMapper.mapper.toDto(transactionRepository.findById(id).get());
    }

    @Override
    public void add(TransactionDTO entity) {
        transactionRepository.save(TransactionMapper.mapper.toEntity(entity));
    }

    @Override
    public void delete(TransactionDTO entity) {
        transactionRepository.delete(TransactionMapper.mapper.toEntity(entity));
    }

    @Override
    public void deleteById(Long entityId) {
        transactionRepository.deleteById(entityId);
    }

    @Override
    public void update(TransactionDTO entity) {
        transactionRepository.save(TransactionMapper.mapper.toEntity(entity));
    }
}