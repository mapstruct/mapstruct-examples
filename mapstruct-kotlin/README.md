# MapStruct with Kotlin

Example usage of Mapstruct and Kotlin with JDK-8 Bytecode. This is achieved by using the [Kotlin Annotation Processing Tool (KAPT)](https://kotlinlang.org/docs/reference/kapt.html).

## Code

In this example we want to map between a Person (Model) and a PersonDto (DTO).

```kotlin
data class Person(var firstName: String?, var lastName: String?, var phoneNumber: String?, var birthdate: LocalDate?) {
    // Necessary for MapStruct
    constructor() : this(null, null, null, null)
}
```

```kotlin
data class PersonDto(var firstName: String?, var lastName: String?, var phone: String?, var birthdate: LocalDate?) {
    // Necessary for MapStruct
    constructor() : this(null, null, null, null)
}
```

The MapStruct converter:

```kotlin
@Mapper
interface PersonConverter {

    @Mapping(source = "phoneNumber", target = "phone")
    fun convertToDto(person: Person) : PersonDto

    @InheritInverseConfiguration
    fun convertToModel(personDto: PersonDto) : Person

}
```

Usage:

```kotlin
val converter = Mappers.getMapper(PersonConverter::class.java) // or PersonConverterImpl()

val person = Person("Samuel", "Jackson", "0123 334466", LocalDate.of(1948, 12, 21))

val personDto = converter.convertToDto(person)
println(personDto)

val personModel = converter.convertToModel(personDto)
println(personModel)
```

## Further documentation

Using kapt: https://kotlinlang.org/docs/reference/kapt.html

MapStruct: http://mapstruct.org/

Kotlin: https://kotlinlang.org/ 

## Maven Setup

Add Mapstruct-JDK8 to your dependencies

```xml
<dependency>
  <groupId>org.mapstruct</groupId>
  <artifactId>mapstruct-jdk8</artifactId>
  <version>${mapstruct.version}</version>
</dependency>
```

Add an execution to the kotlin-maven-plugin with the kapt goal and mapstruct as annotation processor:

```xml

<plugin>
  <groupId>org.jetbrains.kotlin</groupId>
  <artifactId>kotlin-maven-plugin</artifactId>
  <version>${kotlin.version}</version>
  <executions>
    <execution>
        <id>kapt</id>
        <goals>
            <goal>kapt</goal>
        </goals>
        <configuration>
            <sourceDirs>
                <sourceDir>src/main/kotlin</sourceDir>
                <sourceDir>src/main/java</sourceDir>
            </sourceDirs>
            <annotationProcessorPaths>
                <annotationProcessorPath>
                    <groupId>org.mapstruct</groupId>
                    <artifactId>mapstruct-processor</artifactId>
                    <version>${mapstruct.version}</version>
                </annotationProcessorPath>
            </annotationProcessorPaths>
        </configuration>
    </execution>
  ...
  </executions>
  ....
</plugin>
```
