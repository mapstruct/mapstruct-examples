package de.kevcodez.model

import java.time.LocalDate

data class Person(var firstName: String?, var lastName: String?, var phoneNumber: String?, var birthdate: LocalDate?) {

    constructor() : this(null, null, null, null)

}