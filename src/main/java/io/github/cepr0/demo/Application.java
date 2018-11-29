package io.github.cepr0.demo;

import org.mapstruct.factory.Mappers;

public class Application {

	public static void main(String[] args) {

		FoobarMapper foobarMapper = Mappers.getMapper(FoobarMapper.class);
		FooBarDto fooBarDto = new FooBarDto(1, null);
		FooBar fooBar = foobarMapper.fromDto(fooBarDto);
		System.out.println(fooBar);
	}
}
