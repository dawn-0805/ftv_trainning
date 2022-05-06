package com.ftvtraining.api;

import com.ftvtraining.dto.ContractDto;
import com.ftvtraining.dto.ContractSearchDto;
import com.ftvtraining.dto.response.ContractResponseDto;

import com.ftvtraining.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/contractcustom")
public class ContractApiCustom {

    private  final IContractService contractService;

    @Autowired
    public ContractApiCustom(IContractService contractService) {
        this.contractService = contractService;
    }


    @PostMapping("/{page}/{pageSize}")
    public ResponseEntity<?> getContract(@RequestBody ContractSearchDto contractDto,@PathVariable int page, @PathVariable int pageSize){
    	
        Pageable pageable = PageRequest.of(page-1,pageSize);
        List<ContractDto> list = contractService.findByCondition(contractDto,pageable);
        ContractResponseDto responseDto = new ContractResponseDto();
        if (list.size() == 0 ){
            responseDto.setContent(list);
        }
        responseDto.setContent(list);
        responseDto.setTotalElements(contractService.count(contractDto));
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

}
