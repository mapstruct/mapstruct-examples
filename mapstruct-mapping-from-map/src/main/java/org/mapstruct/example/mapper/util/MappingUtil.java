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
package org.mapstruct.example.mapper.util;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/**
 * @author Adam Gurgul
 */
public class MappingUtil {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Ip {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public static @interface Server {
    }

    @Ip
    public String ip(Map<String, Object> in) {
        return (String) in.get("ip");
    }

    @Server
    public String server(Map<String, Object> in) {
        return (String) in.get("server");
    }

}
