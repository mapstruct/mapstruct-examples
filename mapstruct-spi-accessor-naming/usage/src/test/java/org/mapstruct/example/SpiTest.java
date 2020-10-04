/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example;

import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.example.dto.GolfPlayer;
import org.mapstruct.example.dto.GolfPlayerDto;
import org.mapstruct.example.mapper.GolfPlayerMapper;

/**
 * @author Sjaak Derksen
 */
public class SpiTest {
    /**
     * Test if everything is working when sources are present
     */
    @Test
    public void test() {
        GolfPlayer golfPlayer1 = new GolfPlayer();
        golfPlayer1.withName( "Tiger Woods" ).withHandicap( 12 );

        GolfPlayerDto dto = GolfPlayerMapper.INSTANCE.toDto( golfPlayer1 );

        GolfPlayer golfPlayer2 = GolfPlayerMapper.INSTANCE.toPlayer( dto );

        Assert.assertEquals( "Tiger Woods", golfPlayer2.name() );
        Assert.assertEquals( 12L, golfPlayer2.handicap(), 0 );
    }
}
