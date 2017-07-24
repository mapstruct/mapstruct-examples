package de.kevcodez.dto

import java.time.LocalDate

data class PersonDto(var firstName: String?, var lastName: String?, var phone: String?, var birthdate: LocalDate?) {

    // Necessary for MapStruct
    constructor() : this(null, null, null, null)

}