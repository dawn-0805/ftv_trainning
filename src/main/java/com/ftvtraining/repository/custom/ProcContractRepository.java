package com.ftvtraining.repository.custom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ftvtraining.dto.ContractSearchDto;

public interface ProcContractRepository {

  Object findAllByProc(ContractSearchDto searchDto) throws JsonProcessingException;
}
