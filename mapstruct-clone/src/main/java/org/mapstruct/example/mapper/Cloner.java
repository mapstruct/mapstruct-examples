/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;
import org.mapstruct.example.dto.CustomerDto;
import org.mapstruct.factory.Mappers;

/**
 * @author Sjaak Derksen
 *
 * By defining all methods, we force MapStruct to generate new objects for each mapper in stead of
 * taking shortcuts by mapping an object directly.
 */
@Mapper(mappingControl = DeepClone.class)
public interface Cloner {

    Cloner MAPPER = Mappers.getMapper( Cloner.class );

    CustomerDto clone(CustomerDto customerDto);
}
