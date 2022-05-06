package com.ftvtraining.converter;


import com.ftvtraining.dto.ContractDto;
import com.ftvtraining.enity.ContractEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContractConverter {


    @Autowired
    private ModelMapper modelMapper;


    public ContractEntity convertToEntity(ContractDto dto){
        ContractEntity entity = modelMapper.map(dto, ContractEntity.class);
        //entity.setMaHD(dto.getId());
        return  entity;
    }


    public ContractDto convertToDto(ContractEntity entity){
        ContractDto dto = modelMapper.map(entity, ContractDto.class);
        //dto.setId(entity.getMaHD());
        return  dto;
    }
}
