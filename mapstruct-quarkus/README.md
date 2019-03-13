# MapStruct + Quarkus

This example demonstrates how easy it is to use MapStruct in a [Quarkus](https://quarkus.io) application.

The example was basically built with the following steps:

1. Create a new Quarkus application

   ```
   mvn io.quarkus:quarkus-maven-plugin:0.11.0:create -DprojectGroupId=org.mapstruct.examples.quarkus -DprojectArtifactId=mapstruct-examples-quarkus -DclassName="org.mapstruct.example.quarkus.PersonResource" -Dpath="/person" -Dextensions="resteasy-jsonb"
   ```

2. Add MapStruct as described in the [reference guide](http://mapstruct.org/documentation/dev/reference/html/#_apache_maven)
3. Set CDI as the default component-model (see [reference guide](http://mapstruct.org/documentation/dev/reference/html/#configuration-options))
4. Define a mapper and inject it with `@Inject` in the service

That's it!

### Native images

As MapStruct is not using reflection within the mappers native images are supported as long as CDI is used to retrieve the mappers.
Just try to package your Quarkus application in a native image and feel the speed!

```
mvn package -Dnative
```

In case you prefer to use `Mappers.getMapper(...)` be aware that this is not automatically supported by native images. Internally the `getMapper` method uses reflection to retrieve the mapper implementation. This is the only place where MapStruct uses reflection and thus it causes issues with native images.

There are some workarounds by defining additional metadata used during native image creation by GraalVM. For example you can create a `Feature` as described [here](https://github.com/oracle/graal/blob/master/substratevm/REFLECTION.md) and register all you mapper implementations and their constructor(s).

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

When using the Quarkus dev mode the mapper will not automatically be (re)generated.
That means you have to compile (and restart) your application in case you made a change that affects the mapper.
