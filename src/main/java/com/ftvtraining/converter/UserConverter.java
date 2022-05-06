package com.ftvtraining.converter;


import com.ftvtraining.dto.UserDto;
import com.ftvtraining.enity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserEntity convertToEntity(UserDto dto){
        UserEntity entity = modelMapper.map(dto,UserEntity.class);
        return  entity;
    }

    public UserDto convertToDto(UserEntity entity){
        UserDto dto = modelMapper.map(entity,UserDto.class);
        return  dto;
    }

}
