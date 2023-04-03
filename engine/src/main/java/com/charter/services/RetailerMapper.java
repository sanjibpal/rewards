package com.charter.services;

import com.charter.dto.RetailerDto;
import com.charter.entities.Retailer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface RetailerMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, resultType = Retailer.class)
    Retailer updateCustomerFromDto(RetailerDto dto);
}
