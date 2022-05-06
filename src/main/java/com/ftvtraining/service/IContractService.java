package com.ftvtraining.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ftvtraining.dto.ContractDto;
import com.ftvtraining.dto.ContractSearchDto;
import com.ftvtraining.enity.ContractEntity;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IContractService {

    List<ContractDto> findAll();

    List<ContractDto> findByCondition(ContractSearchDto contractDto , Pageable pageable);

    int count(ContractSearchDto contractSearchDto);
    Object findAllByProc(ContractSearchDto contractDto ) throws JsonProcessingException;


    Page<ContractEntity> listByPage(int pageNumber ,int pageSize ,String sortField , String sortDir, String keyword );
    ContractEntity save(ContractEntity entity) throws NotFoundException;
    ContractDto findById(Integer id) throws NotFoundException;
    void deleteContract(List<Integer> ids) throws NotFoundException;
    void delete(Integer id);


}
