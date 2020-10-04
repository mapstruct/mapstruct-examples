/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
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
