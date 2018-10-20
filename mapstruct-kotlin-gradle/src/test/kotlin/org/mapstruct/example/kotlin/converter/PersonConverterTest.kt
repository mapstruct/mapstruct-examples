package org.mapstruct.example.kotlin.converter

import org.mapstruct.example.kotlin.dto.PersonDto
import org.mapstruct.example.kotlin.model.Person

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers
import java.time.LocalDate

class PersonConverterTest {

    @Test
    fun testConvertToDto() {
        val converter = Mappers.getMapper(PersonConverter::class.java)

        val person = Person("Samuel", "Jackson", "0123 334466", LocalDate.of(1948, 12, 21))

        val personDto = converter.convertToDto(person)
        assertThat(personDto).isNotNull
        assertThat(personDto.firstName).isEqualTo("Samuel")
        assertThat(personDto.lastName).isEqualTo("Jackson")
        assertThat(personDto.phone).isEqualTo("0123 334466")
        assertThat(personDto.birthdate).isEqualTo(LocalDate.of(1948, 12, 21))
    }

    @Test
    fun testConvertToModel() {
        val converter = Mappers.getMapper(PersonConverter::class.java)

        val personDto = PersonDto("Samuel", "Jackson", "0123 334466", LocalDate.of(1948, 12, 21))

        val person = converter.convertToModel(personDto)
        assertThat(person).isNotNull
        assertThat(person.firstName).isEqualTo("Samuel")
        assertThat(person.lastName).isEqualTo("Jackson")
        assertThat(person.phoneNumber).isEqualTo("0123 334466")
        assertThat(person.birthdate).isEqualTo(LocalDate.of(1948, 12, 21))
    }
}
