package com.ddd.utils;

public class PersonId extends SimpleId<Long> {

	private PersonId(Long internal) {
		super(internal);
	}

	public static PersonId valueOf(long id) {
		//some validation if needed
		return new PersonId(id);
	}
}
