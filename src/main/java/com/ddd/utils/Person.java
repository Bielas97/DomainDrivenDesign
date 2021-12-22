package com.ddd.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Person {

	private final PersonId id;

	private final String name;

	private final String surname;

	private final int age;

}
