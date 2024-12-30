package com.examents.tsgorkyramos.config;

import com.examents.tsgorkyramos.dto.PersonaDTO;
import com.examents.tsgorkyramos.model.Persona;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean(name = "defaultMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
