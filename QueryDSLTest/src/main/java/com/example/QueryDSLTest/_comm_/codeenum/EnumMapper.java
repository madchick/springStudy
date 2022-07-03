package com.example.QueryDSLTest._comm_.codeenum;

import com.example.QueryDSLTest._comm_.codeenum.codedata.UserType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class EnumMapper {

    @Bean
    public EnumMapperFactory createEnumMapperFactory() {
        EnumMapperFactory enumMapperFactory = new EnumMapperFactory(new LinkedHashMap<>());
        enumMapperFactory.put("UserType", UserType.class);

        return enumMapperFactory;
    }

}
