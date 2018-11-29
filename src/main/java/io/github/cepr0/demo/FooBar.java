package io.github.cepr0.demo;

import lombok.Data;

@Data
//@Builder
public class FooBar {

	private int foo;

//	@Builder.Default
	private String bar = "default value";
}
