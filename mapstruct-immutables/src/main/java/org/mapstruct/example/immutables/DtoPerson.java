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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(builder = DtoPerson.Builder.class)
@ExampleStyle
public interface DtoPerson {
    String getUuid();

    String getFirstName();

    String getLastName();

    default String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    // Required for MapStruct to find the builder
    static Builder builder() {
        return new Builder();
    }

    // And Builder resides in generated Immutable implementation, which is private protected.
    // See https://immutables.github.io/json.html#jackson
    class Builder extends ImmutableDtoPerson.Builder {
    }
}