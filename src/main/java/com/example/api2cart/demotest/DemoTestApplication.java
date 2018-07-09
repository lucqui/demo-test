package com.example.api2cart.demotest;

import com.example.api2cart.demotest.dao.MerchantRepository;
import com.example.api2cart.demotest.dao.TransactionRepository;
import com.example.api2cart.demotest.dao.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;
import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories("com.example.api2cart.demotest.dao")
@EntityScan("com.example.api2cart.demotest.model")
public class DemoTestApplication implements CommandLineRunner {

    private DataSource dataSource;
    private UserRepository userRepository;
    private MerchantRepository merchantRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setMerchantRepository(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Autowired


    public static void main(String[] args) {
        SpringApplication.run(DemoTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(merchantRepository.findAll());
        System.out.println(userRepository.findAll());
        System.out.println(transactionRepository.findAll());
    }
}
