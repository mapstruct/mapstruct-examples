# MapStruct + Quarkus

This example demonstrates how easy it is to use MapStruct in a [Quarkus](https://quarkus.io) application.

The example was basically built with the following steps:

1. Create a new Quarkus application

   ```
   mvn io.quarkus:quarkus-maven-plugin:0.11.0:create -DprojectGroupId=org.mapstruct.examples.quarkus -DprojectArtifactId=mapstruct-examples-quarkus -DclassName="org.mapstruct.example.quarkus.PersonResource" -Dpath="/person" -Dextensions="resteasy-jsonb"
   ```

2. Add the `mapstruct-processor` as a regular `provided` scoped dependency and *not* as described in the 
[reference guide](http://mapstruct.org/documentation/dev/reference/html/#_apache_maven)
   
   ```xml
   <dependency>
     <groupId>org.mapstruct</groupId>
     <artifactId>mapstruct-processor</artifactId>
     <version>${org.mapstruct.version}</version>
     <scope>provided</scope>
   </dependency>
   ```

3. Set CDI as the default component-model (see [reference guide](http://mapstruct.org/documentation/dev/reference/html/#configuration-options))
4. Define a mapper and inject it with `@Inject` in the service

That's it!

### Native images

As MapStruct is not using reflection within the mappers native images are supported as long as CDI is used to retrieve the mappers.
Just try to package your Quarkus application in a native image and feel the speed!

```
mvn package -Dnative
```

In case you prefer to use `Mappers.getMapper(...)` be aware that this is not automatically supported by native images. Internally the `getMapper` method uses reflection to 
retrieve the mapper implementation. 
This is the only place where MapStruct uses reflection and thus it causes issues with native images.

There are some workarounds by defining additional metadata used during native image creation by GraalVM. For example you can create a `Feature` as described 
[here](https://github.com/oracle/graal/blob/master/substratevm/REFLECTION.md) and register all you mapper implementations and their constructor(s).

For example if you just have a `FoobarMapper` the feature might look like this:

```java
@AutomaticFeature
class MapstructMapperFeature implements Feature {
  public void beforeAnalysis(BeforeAnalysisAccess access) {
    try {
      RuntimeReflection.register(FoobarMapperImpl.class);
      RuntimeReflection.register(FoobarMapperImpl.class.getConstructors());
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }
}
```

_(As `FoobarMapperImpl` is a generated class you first have to generate your mappers before you can define this class, otherwise you will get compiliation issues)_


### One drawback

When using the Quarkus dev mode the mapper will automatically be (re)generated in case you make change to the `@Mapper` annotated class.
Changing a dependent class (like `PersonDto` in this example) will not (re)generate the mapper implementation.

As a workaround you can quit the dev-mode, recompile and start the application once again or you can make a (temporary) change to the `@Mapper` annotated class so that it
will be picked up and a valid implementation will be generated.

*Pay attention*: You have to add the mapstruct-processor as described above and *not* using the `maven-compile-plugin`.
