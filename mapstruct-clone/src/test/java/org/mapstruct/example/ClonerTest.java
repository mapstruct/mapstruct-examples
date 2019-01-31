/**
 *  Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mapstruct.example.dto.CustomerDto;
import org.mapstruct.example.dto.OrderItemDto;
import org.mapstruct.example.dto.OrderItemKeyDto;
import org.mapstruct.example.mapper.Cloner;

/**
 *
 * @author Sjaak Derksen
 */
public class ClonerTest {

    @Test
    public void testMapDtoToEntity() {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId( 10L );
        customerDto.setCustomerName("Jaques" );
        OrderItemDto order1 = new OrderItemDto();
        order1.setName ("Table" );
        order1.setQuantity( 2L );
        customerDto.setOrders( new ArrayList<>( Collections.singleton( order1 ) ) );
        OrderItemKeyDto key = new OrderItemKeyDto();
        key.setStockNumber( 5 );
        Map stock = new HashMap(  );
        stock.put( key, order1 );
        customerDto.setStock( stock );

        CustomerDto customer = Cloner.MAPPER.clone( customerDto );

        // check if cloned
        assertThat( customer.getId() ).isEqualTo( 10 );
        assertThat( customer.getCustomerName() ).isEqualTo( "Jaques" );
        assertThat( customer.getOrders() )
            .extracting( "name", "quantity" )
            .containsExactly( tuple( "Table", 2L ) );
        assertThat( customer.getStock()  ).isNotNull();
        assertThat( customer.getStock() ).hasSize( 1 );

        Map.Entry<OrderItemKeyDto, OrderItemDto> entry = customer.getStock().entrySet().iterator().next();
        assertThat( entry.getKey().getStockNumber() ).isEqualTo( 5 );
        assertThat( entry.getValue().getName() ).isEqualTo( "Table" );
        assertThat( entry.getValue().getQuantity() ).isEqualTo( 2L );

        // check mapper really created new objects
        assertThat( customer ).isNotSameAs( customerDto );
        assertThat( customer.getOrders().get( 0 ) ).isNotEqualTo( order1 );
        assertThat( entry.getKey() ).isNotEqualTo( key );
        assertThat( entry.getValue() ).isNotEqualTo( order1 );
        assertThat( entry.getValue() ).isNotEqualTo( customer.getOrders().get( 0 ) );
    }
}
