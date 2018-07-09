package com.example.api2cart.demotest.dao;

import com.example.api2cart.demotest.model.Merchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant, Long> {

}
