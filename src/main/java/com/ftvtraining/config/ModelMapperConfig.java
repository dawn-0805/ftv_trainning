package com.ftvtraining.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ftvtraining")
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }


}
