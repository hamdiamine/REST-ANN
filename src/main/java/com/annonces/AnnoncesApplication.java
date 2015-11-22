package com.annonces;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class AnnoncesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnoncesApplication.class, args);
    }


    /***
     * create a custom object mapper bean that will be used instead of the one provided provided spring
     * The custom object mapper activate the hibernate 4 jackson module and force to not lazy load hibernate association
     * when serialising the entity object.
     */
    @Bean
    @Primary
    public ObjectMapper objectMapperBean(){
        //use the hibernate module for jackson serialization
        final Hibernate4Module hibernate4Module = new Hibernate4Module();
        hibernate4Module.configure(Hibernate4Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, false); //don't force lazy loading

        //activate the hibernate jackson module for the project ObjectMapper bean.
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(hibernate4Module);
        return objectMapper;
    }
}
