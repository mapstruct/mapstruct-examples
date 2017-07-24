package org.mapstruct.example.kotlin.model

import java.time.LocalDate

data class Person(var firstName: String?, var lastName: String?, var phoneNumber: String?, var birthdate: LocalDate?) {

    // Necessary for MapStruct
    constructor() : this(null, null, null, null)

}
