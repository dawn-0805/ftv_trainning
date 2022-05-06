package com.ftvtraining.api;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.ftvtraining.dto.ContractSearchDto;
import com.ftvtraining.service.IContractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/contractproc")
public class ContractApiProc {


    @Autowired
    private IContractService contractService;

    @GetMapping()
    public ResponseEntity<?> getContract(ContractSearchDto contractSearchDto) throws JsonProcessingException {

        Object list = contractService.findAllByProc(contractSearchDto);
        if (list == null){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}