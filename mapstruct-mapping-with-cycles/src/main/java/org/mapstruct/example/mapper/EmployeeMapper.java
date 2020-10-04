/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.mapper;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.example.dto.Employee;
import org.mapstruct.example.dto.EmployeeDto;
import org.mapstruct.factory.Mappers;

/**
 * @author Filip Hrisafov
 */
@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper( EmployeeMapper.class );

    @Mapping(source = "employeeName", target = "name")
    Employee toEmployee(EmployeeDto employeeDto, @Context CycleAvoidingMappingContext context);

    @InheritInverseConfiguration
    EmployeeDto fromEmployee(Employee employee, @Context CycleAvoidingMappingContext context);
}
