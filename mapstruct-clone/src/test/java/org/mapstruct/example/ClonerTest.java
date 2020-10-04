/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
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
