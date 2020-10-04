/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.example.quarkus.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonService {

    public Person loadPerson() {
        return new Person("Bob", "Miller");
    }

}
