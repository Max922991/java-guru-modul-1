package com.example.javagurumodul1.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;

public class MethodsImpl implements Methods {

    @Value("${spring.dev.path}")
    private String path;
    @Override
    public void writeToJson(String path) {

        Object object = new Object();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(path), object);
            System.out.println("Данные успешно записаны");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Jakarta readFromJson(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        Jakarta jakarta = new Jakarta();
        try {
            jakarta = objectMapper.readValue(new File(path), Jakarta.class);
            if (jakarta != null) {
                System.out.println("jakarta " + jakarta.getVersion());
                System.out.println("jakarta " + jakarta.getDescription());
                System.out.println("jakarta " + jakarta.getTechnologies());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jakarta;
    }

    @Override
    public void updateTechnology(Technology technology) {

        Technology technologyUpdate = new Technology();

        technologyUpdate.setTechnologyName(technology.getTechnologyName());
        technologyUpdate.setTechnologyDescription(technology.getTechnologyDescription());
    }
}
