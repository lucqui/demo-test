package com.example.api2cart.demotest.dto.mapper;

import com.example.api2cart.demotest.dto.TransactionDTO;
import com.example.api2cart.demotest.dto.UserDTO;
import com.example.api2cart.demotest.model.Transaction;
import com.example.api2cart.demotest.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper mapper = Mappers.getMapper(TransactionMapper.class);

    Transaction toEntity(TransactionDTO transactionDto);
    TransactionDTO toDto(Transaction transaction);
    List<Transaction> toEntity(List<TransactionDTO> dtoList);
    List<TransactionDTO> toDto(List<Transaction> entityList);
}
