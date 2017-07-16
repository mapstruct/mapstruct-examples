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

import org.junit.Test;
import org.mapstruct.example.dto.Source;
import org.mapstruct.example.dto.Target;
import org.mapstruct.example.mapper.SourceTargetMapper;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 *
 * @author Adam Gurgul
 */
public class SourceTargetMapperTest {

    public SourceTargetMapperTest() {
    }

    /**
     * Test of toTarget method, of class SourceTargetMapper.
     */
    @Test
    public void testMapperOnExistingIpAndServer() {

        Map<String, Object> map = new HashMap<>();
        map.put("ip", "127.0.0.1");
        map.put("server", "168.192.1.1");

        Source s = new Source(map);
        Target t = SourceTargetMapper.MAPPER.toTarget( s );

        assertEquals(t.getIp(), "127.0.0.1");
        assertEquals(t.getServer(), "168.192.1.1");

    }

    @Test
    public void testMapperOnNonExistingIpAndServer() {

        Map<String, Object> map = new HashMap<>();
        Source s = new Source(map);
        Target t = SourceTargetMapper.MAPPER.toTarget( s );

        assertNull(t.getIp());
        assertNull(t.getServer());

    }



}
