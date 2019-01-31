/**
 * Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
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

import java.util.List;
import java.util.Map;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.example.dto.CustomerDto;
import org.mapstruct.example.dto.OrderItemDto;
import org.mapstruct.example.dto.OrderItemKeyDto;
import org.mapstruct.factory.Mappers;

/**
 * @author Sjaak Derksen
 *
 * By defining all methods, we force MapStruct to generate new objects for each mapper in stead of
 * taking shortcuts by mapping an object directly.
 */
@Mapper
public interface Cloner {

    Cloner MAPPER = Mappers.getMapper( Cloner.class );

    CustomerDto clone(CustomerDto customerDto);

    List<OrderItemDto> clone(List<OrderItemDto> orders);

    OrderItemDto clone(OrderItemDto order);

    Map<OrderItemKeyDto, OrderItemDto> clone(Map<OrderItemKeyDto, OrderItemDto> stock);

    OrderItemKeyDto clone( OrderItemKeyDto orderItemKeyDto );
}
