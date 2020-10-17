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


import org.immutables.value.Value;

import static org.immutables.value.Value.Style.ImplementationVisibility.PACKAGE;

/**
 * Our ExampleStyle to make it easier to reuse annotations on our org.immutables interfaces.
 * <p>
 * Details: https://immutables.github.io/style.html
 * <pre>
 * builder = "new"  is required for serializing with jackson
 * visibility to package is nice to hide implementation details from users using our builders
 * overshadowImplementation sets return types on builders to be the interface instead of the generated immutable class. ( https://immutables.github.io/immutable.html#builder )
 */
@Value.Style(builder = "new", visibility = PACKAGE, overshadowImplementation = true)
public @interface ExampleStyle {
}
