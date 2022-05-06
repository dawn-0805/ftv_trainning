package com.ftvtraining.repository.custom.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftvtraining.dto.ContractSearchDto;
import com.ftvtraining.exception.ContractException;
import com.ftvtraining.repository.custom.ProcContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.util.Map;


public class ProcContractRepositoryImpl implements ProcContractRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private  ObjectMapper objectMapper;
    
    @Override
    public Object findAllByProc(ContractSearchDto searchDto)  {

        try{

            String data = objectMapper.writeValueAsString(searchDto);
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PROC_HOPDONG")
                    .withProcedureName("get_all_hopdong");
            SqlParameterSource inParams = new MapSqlParameterSource()
                    .addValue("pi_input", data);
            Map<String,Object> result = jdbcCall.execute(inParams);
            String errCode = (String) result.get("PO_ERR");
            String errDesc = (String) result.get("PO_DESC");
            if ( !errCode.equals("0") && null != errDesc ){
                throw  new ContractException(errDesc);
            }
            return  result.get("PO_DATA");
        }catch (JsonProcessingException | ContractException ex){
            ex.printStackTrace();
            return new Object();
        }
    }
}
