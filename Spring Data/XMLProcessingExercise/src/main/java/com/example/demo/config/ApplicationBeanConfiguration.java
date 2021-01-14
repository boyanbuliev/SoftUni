package com.example.demo.config;

import com.example.demo.utils.ValidationUtil;
import com.example.demo.utils.ValidationUtilImpl;
import com.example.demo.utils.XmlParser;
import com.example.demo.utils.XmlParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public XmlParser xmlParser() {
        return new XmlParserImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ValidationUtil validationUtil() {
        return new ValidationUtilImpl();
    }

    @Bean
    public Random random() {
        return new Random();
    }
}
