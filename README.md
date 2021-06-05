# MapStruct Examples

This repository contains examples showing how to use [MapStruct](http://mapstruct.org/), a Java annotation processor for the generation of type-safe bean mapping classes.

Currently, the following examples exist:

* [_mapstruct-on-ant_](mapstruct-on-ant): Shows how to use MapStruct in Ant-based projects; to build this example, run `ant build` on the command line
* [_mapstruct-on-gradle_](mapstruct-on-gradle): Shows how to use MapStruct in Gradle-based projects; to build the example project, run `./gradlew clean build` on the command line
* [_mapstruct-on-bazel_](mapstruct-on-bazel): Shows how to use MapStruct in Bazel-based projects; to build the example project, run `bazel build //...` on the command line, to test the project, run `bazel test //...`.
* [_mapstruct-lombok_](mapstruct-lombok): Shows how to use MapStruct together with Lombok (with both a Maven `pom.xml` and a Gradle `build.gradle`); to build the example project, run either `mvn clean install` or `./gradlew clean build` on the command line
* [_mapstruct-iterable-non-iterable_](mapstruct-iterable-to-non-iterable): Shows how by means of a mapper util class conversions can be made from an iterable- to its non-iterable element
* [_mapstruct-mapping-from-map_](mapstruct-mapping-from-map): Shows how by means of a mapper util class and qualifiers extracting value can be carried out on Maps. Watch [mapstruct/mapstruct#1075](https://github.com/mapstruct/mapstruct/issues/1075) for native support.
* [_mapstruct-rounding_](mapstruct-rounding): Shows how by means of a mapper util class and qualifiers roundings can be carried out on Numbers
* [_mapstruct-updatemethods_](mapstruct-updatemethods-1): Shows how to update an existing target object
* [_mapstruct-field-mapping_](mapstruct-field-mapping): Shows how MapStruct can be used with "struct" like objects with public fields
* [_mapstruct-nested-bean-mappings_](mapstruct-nested-bean-mappings): Shows how to map object graphs via a main root method
* [_mapstruct-mapping-with-cycles_](mapstruct-nested-bean-mappings): Shows how to map object graphs that can contain cycles
* [_mapstruct-spi-accessor-naming_](mapstruct-spi-accessor-naming): Example on how to use the Service Provider Interface (SPI) for a custom accessor naming strategy.
* [_mapstruct-protobuf3_](mapstruct-protobuf3): Example on how to use protobuf3 with MapStruct
* [_mapstruct-kotlin_](mapstruct-kotlin): Example on how to use MapStruct with Kotlin using KAPT (Kotlin Annotation Processing Tool)
* [_mapstruct-kotlin-gradle_](mapstruct-kotlin-gradle): Example on how to use MapStruct with Kotlin and Gradle Kotlin DSL using KAPT
* [_mapstruct-jpa-child-parent_](mapstruct-jpa-child-parent): Example on how to use @Context in relation to parent / child relations in JPA)
* [_mapstruct-suppress-unmapped_](mapstruct-suppress-unmapped): Shows how mapping to target properties can be ignored without warning by default in a mixed scenario. However bean property mappings that have the same name will still be applied.
* [_mapstruct-lookup-entity-with-id_](mapstruct-lookup-entity-with-id): Shows how an object with composite key can be read from the database in a mapping method.
* [_mapstruct-clone_](mapstruct-clone): Shows how an object can be deeply cloned by defining all mapping methods.
* [_mapstruct-metadata-annotations_](mapstruct-metadata-with-annotations): Demonstrates how to read annotations and use them as mapping instruction.
* [_mapstruct-mappers-repo_](mapstruct-mapper-repo): Demonstrates how one can build a repo of mappers by means of code generation.

## License

The examples in this project are licensed under the Apache License, Version 2.0.
