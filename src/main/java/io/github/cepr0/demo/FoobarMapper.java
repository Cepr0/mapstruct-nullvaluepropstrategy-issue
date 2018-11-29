package io.github.cepr0.demo;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface FoobarMapper {
	FooBar fromDto(FooBarDto fooBarDto);
}
