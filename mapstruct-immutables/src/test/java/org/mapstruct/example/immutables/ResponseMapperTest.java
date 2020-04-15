/**
 * Copyright 2020 MapStruct developers
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
package org.mapstruct.example.immutables;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseMapperTest {

    @Test
    public void testResponseMapper() {
        DtoPerson.Builder barBuilder = new DtoPerson.Builder()
                .uuid("foo")
                .firstName("John")
                .lastName("Snow");


        assertThat(ResponseMapper.INSTANCE.mapFrom(barBuilder.build()))
                .isEqualTo(new ApiPerson.Builder()
                        .id("foo")
                        .firstName("John")
                        .fullName("John Snow")
                        .mapperDoingFullName("John Snow")
                        .build());

    }

    @Test
    public void testResponseMapperWithSerializingPersonToJson() throws JsonProcessingException {
        DtoPerson.Builder personFromDatabase = new DtoPerson.Builder()
                .uuid("foo")
                .firstName("John")
                .lastName("Snow");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ResponseMapper.INSTANCE.mapFrom(personFromDatabase.build()));
        assertThat(json).isEqualTo("{\"id\":\"foo\",\"firstName\":\"John\",\"fullName\":\"John Snow\",\"mapperDoingFullName\":\"John Snow\"}");
    }

}