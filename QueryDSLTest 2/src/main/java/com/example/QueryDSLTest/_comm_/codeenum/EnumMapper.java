package com.haksik.haksikapi._comm_.codeenum;

import com.haksik.haksikapi._comm_.codeenum.codedata.CustomerType;
import com.haksik.haksikapi._comm_.codeenum.codedata.MealType;
import com.haksik.haksikapi._comm_.codeenum.codedata.TicketType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class EnumMapper {

    @Bean
    public EnumMapperFactory createEnumMapperFactory() {
        EnumMapperFactory enumMapperFactory = new EnumMapperFactory(new LinkedHashMap<>());
        enumMapperFactory.put("CustomerType", CustomerType.class);
        enumMapperFactory.put("TicketType", TicketType.class);
        enumMapperFactory.put("MealType", MealType.class);
        return enumMapperFactory;
    }

}
