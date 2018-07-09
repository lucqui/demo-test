package com.example.api2cart.demotest.service.impl;

import com.example.api2cart.demotest.dao.MerchantRepository;
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
    public List<Merchant> getAll() {
        return (List<Merchant>) merchantRepository.findAll();
    }

    @Override
    public Merchant get(Long id) {
        return merchantRepository.findById(id).get();
    }

    @Override
    public void add(Merchant entity) {
        merchantRepository.save(entity);
    }

    @Override
    public void delete(Merchant entity) {
        merchantRepository.delete(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        merchantRepository.deleteById(entityId);
    }

    @Override
    public void update(Merchant entity) {
        merchantRepository.save(entity);
    }
}
