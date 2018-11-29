MapStruct (1_3_0_Beta2) `NullValuePropertyMappingStrategy` with `IGNORE` value, as described [here](http://mapstruct.org/news/2018-11-12-mapstruct-1_3_0_Beta2-is-out-with-java8-as-baseline/#control-how-null-or-not-present-properties-are-updated-within-a-target-bean), doesn't work as expected.

**Target**

```java
@Data
//@Builder
public class FooBar {

	private int foo;

//	@Builder.Default
	private String bar = "default value";
}
``` 

**Source**

```java
@Value
public class FooBarDto {
	private int foo;
	private String bar;
}
```

**Mapper**

```java
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FoobarMapper {
	FooBar fromDto(FooBarDto fooBarDto);
}
```

**Generated Mapper implementation**

```java
public class FoobarMapperImpl implements FoobarMapper {

    @Override
    public FooBar fromDto(FooBarDto fooBarDto) {
        if ( fooBarDto == null ) {
            return null;
        }

        FooBar fooBar = new FooBar();

        fooBar.setFoo( fooBarDto.getFoo() );
        fooBar.setBar( fooBarDto.getBar() );

        return fooBar;
    }
}
```

Here we can see that mapper doesn't perform the check of `fooBarDto.getBar()` result for `null` value; 