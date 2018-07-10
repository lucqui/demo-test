package com.example.api2cart.demotest.service.impl;

import com.example.api2cart.demotest.dao.MerchantRepository;
import com.example.api2cart.demotest.dto.MerchantDTO;
import com.example.api2cart.demotest.dto.mapper.MerchantMapper;
import com.example.api2cart.demotest.model.Merchant;
import com.example.api2cart.demotest.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {

    private MerchantRepository merchantRepository;

    @Autowired
    public void setMerchantRepository(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public List<MerchantDTO> getAll() {
        return MerchantMapper.mapper.toDto((List<Merchant>) merchantRepository.findAll());
    }

    @Override
    public MerchantDTO get(Long id) {
        return MerchantMapper.mapper.toDto(merchantRepository.findById(id).get());
    }

    @Override
    public void add(MerchantDTO entity) {
        merchantRepository.save(MerchantMapper.mapper.toEntity(entity));
    }

    @Override
    public void delete(MerchantDTO entity) {
        merchantRepository.delete(MerchantMapper.mapper.toEntity(entity));
    }

    @Override
    public void deleteById(Long entityId) {
        merchantRepository.deleteById(entityId);
    }

    @Override
    public void update(MerchantDTO entity) {
        merchantRepository.save(MerchantMapper.mapper.toEntity(entity));
    }
}
