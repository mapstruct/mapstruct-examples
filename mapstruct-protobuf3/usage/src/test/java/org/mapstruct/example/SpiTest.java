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
package org.mapstruct.example;

import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.example.mapper.UserMapper;
import org.mapstruct.example.protobuf.GolfPlayer;
import org.mapstruct.example.protobuf.GolfPlayerDto;

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
        golfPlayer1.withName("Tiger Woods").withHandicap(12);

        GolfPlayerDto dto = UserMapper.INSTANCE.toDto(golfPlayer1);

        GolfPlayer golfPlayer2 = UserMapper.INSTANCE.toPlayer(dto);

        Assert.assertEquals("Tiger Woods", golfPlayer2.name());
        Assert.assertEquals(12L, golfPlayer2.handicap(), 0);
    }
}
