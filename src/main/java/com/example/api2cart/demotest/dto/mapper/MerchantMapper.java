package com.example.api2cart.demotest.dto.mapper;

import com.example.api2cart.demotest.dto.MerchantDTO;
import com.example.api2cart.demotest.model.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MerchantMapper {

    MerchantMapper mapper = Mappers.getMapper(MerchantMapper.class);

    Merchant toEntity(MerchantDTO merchantDTO);
    MerchantDTO toDto(Merchant merchant);
    List<Merchant> toEntity(List<MerchantDTO> dtoList);
    List<MerchantDTO> toDto(List<Merchant> entityList);
}
