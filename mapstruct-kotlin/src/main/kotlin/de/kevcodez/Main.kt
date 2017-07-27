package de.kevcodez

import de.kevcodez.converter.PersonConverter
import de.kevcodez.model.Person
import org.mapstruct.factory.Mappers
import java.time.LocalDate

fun main(args: Array<String>) {

    val converter = Mappers.getMapper(PersonConverter::class.java) // or PersonConverterImpl()

    val person = Person("Samuel", "Jackson", "0123 334466", LocalDate.of(1948, 12, 21))

    val personDto = converter.convertToDto(person)
    println(personDto)

    val personModel = converter.convertToModel(personDto)
    println(personModel)

}

