package com.ftvtraining.contract;


import com.ftvtraining.enity.ContractEntity;
import com.ftvtraining.repository.ContractRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ContractRepositoryTests {


    @Autowired
    private ContractRepository repository;


    @Test
    public  void testListContacts(){
        Iterable<ContractEntity> listContactEntities = repository.findAll();
        listContactEntities.forEach(contact -> System.out.println(contact));
    }


    @Test
    public  void testContact(){
        ContractEntity contract = repository.findById(1).get();
        System.out.println(contract.toString());
    }

}
