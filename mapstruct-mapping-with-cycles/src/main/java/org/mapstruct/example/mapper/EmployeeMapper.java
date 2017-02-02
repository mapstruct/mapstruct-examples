/**
 * Copyright 2012-2016 Gunnar Morling (http://www.gunnarmorling.de/)
 * and/or other contributors as indicated by the @authors tag. See the
 * copyright.txt file in the distribution for a full listing of all
 * contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
